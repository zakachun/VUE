package tufts.vue;

import java.awt.*;
import javax.swing.*;

/**
 * Vue application class.
 * Create an application frame and layout all the components
 * we want to see there (including menus, toolbars, etc).
 */
public class VUE
{
    public static void main(String[] args) {
        /*
         * create an example map (this will become
         * map loading code after the viewer is up)
         */
        ConceptMap map = new ConceptMap("Example Map");
        
        /*
         * create the map viewer
         */
        Container mapViewer = new tufts.vue.MapViewer(map);
        installExampleMap(map);

        /*
         * create a an application frame and layout components
         */
        
        JPanel toolPanel = new JPanel();
        toolPanel.setLayout(new BorderLayout());
        toolPanel.add(new DRBrowser(), BorderLayout.CENTER);
        toolPanel.add(new MapItemInspector(), BorderLayout.SOUTH);

        JSplitPane splitPane = new JSplitPane();
        JScrollPane leftScroller = new JScrollPane(toolPanel);

        splitPane.setResizeWeight(0.25); // 25% space to the left component
        splitPane.setContinuousLayout(true);
        splitPane.setOneTouchExpandable(true);
        splitPane.setLeftComponent(leftScroller);
        splitPane.setRightComponent(mapViewer);


        JFrame frame = new JFrame("VUE: Tufts Concept Map Tool");
        frame.setContentPane(splitPane);
        frame.setBackground(Color.white);
        
        frame.pack();
        frame.show();
        frame.repaint();
    }


    static void installExampleMap(ConceptMap map)
    {
        /*
         * create some test nodes & links
         */
        Node n1 = new Node("Test node1");
        Node n2 = new Node("Test node2");
        Node n3 = new Node("foo.txt", new Resource("/tmp/foo.txt"));
        Node n4 = new Node("Tester Node Four");
        n1.setPosition(100, 50);
        n2.setPosition(100, 100);
        n3.setPosition(50, 150);
        n4.setPosition(150, 150);
        map.addNode(n1);
        map.addNode(n2);
        map.addNode(n3);
        map.addNode(n4);
        map.addLink(new Link(n1, n2));
        map.addLink(new Link(n2, n3));
        map.addLink(new Link(n2, n4));
    }
}
