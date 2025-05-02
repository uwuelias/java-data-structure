import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class wu_feng_p8 {
    private static int width = 700;
    private static int height = 350;

    public static void main(String[] args) {
        /*
         * String searchFile = args[0];
         * String sortFile = args[1];
         */

        JFrame frame = new JFrame("lab12");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));

        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("file");

        JMenuItem readSortFile = new JMenuItem("Read Sort File");
        JMenuItem readSearchFile = new JMenuItem("Read Search File");
        JMenuItem exit = new JMenuItem("exit");

        MenuItemActionListener readSortFileListener = new MenuItemActionListener(readSortFile);
        MenuItemActionListener readSearchFileListener = new MenuItemActionListener(readSearchFile);
        MenuItemActionListener exitListener = new MenuItemActionListener(exit);

        readSortFile.addActionListener(readSortFileListener);
        readSearchFile.addActionListener(readSearchFileListener);
        exit.addActionListener(exitListener);

        menuBar.add(file);

        file.add(readSortFile);
        file.add(readSearchFile);
        file.add(exit);

        JPanel leftButtonPanel = new JPanel();
        leftButtonPanel.setBorder(new LineBorder(Color.black, 2));
        GridBagLayout leftGridBagLayout = new GridBagLayout();
        leftButtonPanel.setLayout(leftGridBagLayout);
        leftButtonPanel.setMinimumSize(new Dimension(330, 350));
        leftButtonPanel.setPreferredSize(new Dimension(330, 350));

        // initalize buttons for left button panel
        JButton sortInts = new JButton("sort ints");
        JButton addToBst = new JButton("add to bst");
        JButton addToTreeset = new JButton("add to treeset");
        JButton addToPQ = new JButton("add to priority queue");
        JButton addToHashSet = new JButton("add to hashset");
        JButton addToAL = new JButton("add to array list");
        JButton addToSortedAL = new JButton("add to sorted array list");
        JButton addToArray = new JButton("add to array");

        // initalize labels for left button panel
        JLabel sortIntsLabel = new JLabel("no result");
        JLabel addToBstLabel = new JLabel("no result");
        JLabel addToTreesetLabel = new JLabel("no result");
        JLabel addToPQLabel = new JLabel("no result");
        JLabel addToHashSetLabel = new JLabel("no result");
        JLabel addToLabel = new JLabel("no result");
        JLabel addtoSortedLabel = new JLabel("no result");
        JLabel addToArrayLabel = new JLabel("no result");

        // adding buttons and labels to left button panel

        JPanel rightButtonPanel = new JPanel();
        rightButtonPanel.setBorder(new LineBorder(Color.black, 2));
        GridBagLayout rightGridBagLayout = new GridBagLayout();
        rightButtonPanel.setLayout(rightGridBagLayout);
        rightButtonPanel.setMinimumSize(new Dimension(330, 350));
        rightButtonPanel.setPreferredSize(new Dimension(330, 350));

        JPanel mainButtonPanel = new JPanel();
        mainButtonPanel.setBorder(new LineBorder(Color.black, 2));
        BoxLayout boxLayout = new BoxLayout(mainButtonPanel, BoxLayout.X_AXIS);
        mainButtonPanel.setLayout(boxLayout);

        mainButtonPanel.add(leftButtonPanel);
        mainButtonPanel.add(rightButtonPanel);

        JPanel mainPanel = new JPanel();
        mainPanel.setBorder(new LineBorder(Color.black, 2));
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(menuBar, BorderLayout.NORTH);
        mainPanel.add(mainButtonPanel, BorderLayout.CENTER);

        frame.setContentPane(mainPanel);
        frame.validate();
        frame.setVisible(true);

    }

    static class MenuItemActionListener implements ActionListener {
        private JMenuItem m;

        MenuItemActionListener(JMenuItem m) {
            this.m = m;
        }

        public void actionPerformed(ActionEvent e) {
            System.out.println("action performed on " + m.getText() + " menu item");

            if (m.getText().toLowerCase().equals("exit")) {
                System.exit(0);
            }
        }
    }

}