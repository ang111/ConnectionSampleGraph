public class Test {
    public static void main(String[] args) {
        ConnectionsNetwork network = new ConnectionsNetwork();

        ConnectionNode A = new ConnectionNode(1);
        ConnectionNode B = new ConnectionNode(2);
        ConnectionNode C = new ConnectionNode(3);
        ConnectionNode D = new ConnectionNode(4);
        ConnectionNode E = new ConnectionNode(5);
        ConnectionNode F = new ConnectionNode(6);
        ConnectionNode G = new ConnectionNode(7);

        network.connectNodes(A,B);
        network.connectNodes(A,D);
        network.connectNodes(A,C);
        network.connectNodes(C,A); // redundant- for testing
        network.connectNodes(B,C);
        network.connectNodes(D,E);
        network.connectNodes(F,G);


        System.out.println(network.findMinConnectionLevel(A,A) + " connection");
        System.out.println(network.findMinConnectionLevel(A,B) + " connection");
        System.out.println(network.findMinConnectionLevel(C,D) + " connection");
        System.out.println(network.findMinConnectionLevel(C,E) + " connection");
        System.out.println(network.findMinConnectionLevel(A,F) + " connection");
    }

}
