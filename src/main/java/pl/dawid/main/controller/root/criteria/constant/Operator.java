package pl.dawid.main.controller.root.criteria.constant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.dawid.main.controller.root.criteria.FilterItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

public enum Operator {
    EQUAL {
        public <T> Predicate build(Root<T> root, CriteriaBuilder cb, FilterItem filter, Predicate predicate) {
            Object value = filter.getFieldType().parse(filter.getValue().toString());
            Expression<?> key = root.get(filter.getKey());
            return cb.and(cb.equal(key, value), predicate);
        }
    },

    NOT_EQUAL {
        public <T> Predicate build(Root<T> root, CriteriaBuilder cb, FilterItem filter, Predicate predicate) {
            Object value = filter.getFieldType().parse(filter.getValue().toString());
            Expression<?> key = root.get(filter.getKey());
            return cb.and(cb.notEqual(key, value), predicate);
        }
    },

    LIKE {
        public <T> Predicate build(Root<T> root, CriteriaBuilder cb, FilterItem filter, Predicate predicate) {
            Expression<String> key = root.get(filter.getKey());
            return cb.and(cb.like(cb.upper(key), "%" + filter.getValue().toString().toUpperCase() + "%"), predicate);
        }
    },

    IN {
        public <T> Predicate build(Root<T> root, CriteriaBuilder cb, FilterItem filter, Predicate predicate) {
            List<Object> values = filter.getValues();
            CriteriaBuilder.In<Object> inClause = cb.in(root.get(filter.getKey()));
            for (Object value : values) {
                inClause.value(filter.getFieldType().parse(value.toString()));
            }
            return cb.and(inClause, predicate);
        }
    },

    BETWEEN {
        public <T> Predicate build(Root<T> root, CriteriaBuilder cb, FilterItem filter, Predicate predicate) {
            Object value = filter.getFieldType().parse(filter.getValue().toString());
            Object valueTo = filter.getFieldType().parse(filter.getValueTo().toString());
            if (filter.getFieldType() == FieldType.DATE) {
                LocalDateTime startDate = (LocalDateTime) value;
                LocalDateTime endDate = (LocalDateTime) valueTo;
                Expression<LocalDateTime> key = root.get(filter.getKey());
                return cb.and(cb.and(cb.greaterThanOrEqualTo(key, startDate), cb.lessThanOrEqualTo(key, endDate)), predicate);
            }

            if (filter.getFieldType() != FieldType.CHAR && filter.getFieldType() != FieldType.BOOLEAN) {
                Number start = (Number) value;
                Number end = (Number) valueTo;
                Expression<Number> key = root.get(filter.getKey());
                return cb.and(cb.and(cb.ge(key, start), cb.le(key, end)), predicate);
            }

            logger.info("Can not use between for {} field type.", filter.getFieldType());
            return predicate;
        }
    };

    public abstract <T> Predicate build(Root<T> root, CriteriaBuilder cb, FilterItem request, Predicate predicate);
    private static final Logger logger = LoggerFactory.getLogger(Operator.class);
}
