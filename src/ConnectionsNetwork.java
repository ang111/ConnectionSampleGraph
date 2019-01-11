import java.util.*;

public class ConnectionsNetwork {

    private HashMap<ConnectionNode,ArrayList<ConnectionNode> > networkData;
    private static String NOT_CONNECTED = "Not Connected";

    public ConnectionsNetwork() {
        this.networkData = new HashMap<>();
    }

    public void connectNodes(ConnectionNode n1, ConnectionNode n2) {
        ArrayList<ConnectionNode> n1Connections = networkData.get(n1);
        ArrayList<ConnectionNode> n2Connections = networkData.get(n2);
        if (n1Connections == null) {
            n1Connections = new ArrayList<>();
            networkData.put(n1,n1Connections);
        }
        if (!n1Connections.contains(n2))
            n1Connections.add(n2);

        if (n2Connections == null) {
            n2Connections = new ArrayList<>();
            networkData.put(n2,n2Connections);
        }
        if (!n1Connections.contains(n2))
            n2Connections.add(n1);
    }

    public String findMinConnectionLevel(ConnectionNode n1, ConnectionNode n2) {
        Integer minConnections = findMinConnectionLevelUtil(n1,n2);
        if (minConnections == null) {
            return NOT_CONNECTED;
        }
        return minConnections.toString();
    }


    public ArrayList<ConnectionNode> getFirstLevelConnections(ConnectionNode n) {
        if (networkData != null) {
            return networkData.get(n);
        }
        return null;
    }

    private Integer findMinConnectionLevelUtil(ConnectionNode n1, ConnectionNode n2) {
        if ( n1==null || n2 ==null ) {
            return null;
        }
        if (n1.equals(n2)) {
            return 0;
        }
        HashMap<ConnectionNode,Boolean> visited = new HashMap<>();
        LinkedList<ConnectionNode> queue =  new LinkedList<>();
        LinkedList<Integer> distanceFromBaseNode =  new LinkedList<>();

        visited.put(n1,true);
        queue.add(n1);
        distanceFromBaseNode.add(0);

        while (!queue.isEmpty()) {
            ConnectionNode node = queue.poll();
            int distance = distanceFromBaseNode.poll();
            if (node.equals(n2)) {
                return distance;
            }
            ArrayList<ConnectionNode> connections = getFirstLevelConnections(node);
            if (connections!= null) {
                Iterator<ConnectionNode> itr = connections.iterator();
                while (itr.hasNext()) {
                    ConnectionNode n = itr.next();
                    if (visited.get(n) == null || !visited.get(n)) {
                        visited.put(n,true);
                        queue.add(n);
                        distanceFromBaseNode.add(distance+1);
                    }
                }
            }
        }
        return null;
    }

}
