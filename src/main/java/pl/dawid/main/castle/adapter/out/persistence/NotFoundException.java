package pl.dawid.main.castle.adapter.out.persistence;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Long id) {
        super("Not found object with id: " + id);
    }
}
