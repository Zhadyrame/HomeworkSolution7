public abstract class Aircraft {
    protected String id;

    public Aircraft(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public abstract void receive(String msg);

    public void send(String msg, TowerMediator m) {
        m.broadcast(msg, this);
    }
}
