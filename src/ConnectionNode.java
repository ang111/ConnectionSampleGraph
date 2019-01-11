public class ConnectionNode {
    private Integer id;
    public ConnectionNode(int id) {
       this.id = id;
    }

    // more node data

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void Node (Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object n) {
        ConnectionNode nodeToComp = (ConnectionNode)n;
        if (nodeToComp.getId() == id) {
            return true;
        }
        return false;
    }

    @Override
    public  int hashCode() {
        return id.hashCode();
    }


}
