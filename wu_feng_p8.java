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
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
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
        leftButtonPanel.setLayout(new GridBagLayout());
        leftButtonPanel.setMinimumSize(new Dimension(330, 350));
        leftButtonPanel.setPreferredSize(new Dimension(330, 350));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);

        String[] leftButtonsText = {
                "sort ints", "add to bst", "add to treeset", "add to priority queue", "add to hashset",
                "add to arraylist", "add to sorted arraylist", "add to array", "merge sort ints", "merge2 sort ints",
                "quick sort ints"
        };

        Map<JButton, JLabel> leftButtonLabelMap = new HashMap<>();

        for (int i = 0; i < leftButtonsText.length; i++) {
            JButton button = new JButton(leftButtonsText[i]);
            button.setEnabled(false);
            JLabel label = new JLabel("no result");

            button.setPreferredSize(new Dimension(160, 25));
            label.setPreferredSize(new Dimension(60, 25));

            button.addActionListener(new ButtonActionListener(leftButtonLabelMap));
            leftButtonLabelMap.put(button, label);

            // button
            gbc.gridy = i;
            gbc.gridx = 0;
            leftButtonPanel.add(button, gbc);

            // label
            gbc.gridx = 1;
            leftButtonPanel.add(label, gbc);
        }

        JPanel rightButtonPanel = new JPanel();
        rightButtonPanel.setBorder(new LineBorder(Color.black, 2));
        GridBagLayout rightGridBagLayout = new GridBagLayout();
        rightButtonPanel.setLayout(rightGridBagLayout);
        rightButtonPanel.setMinimumSize(new Dimension(330, 350));
        rightButtonPanel.setPreferredSize(new Dimension(330, 350));

        String[] rightButtonsText = {
                "search sorted ints", "search bst", "search treeset", "search priority queue", "search hashset",
                "search arraylist", "search sorted arraylist", "search array", "search merge sorted ints",
                "search merge2 sorted ints",
                "search quick sorted ints"
        };

        Map<JButton, JLabel> rightButtonLabelMap = new HashMap<>();

        for (int i = 0; i < leftButtonsText.length; i++) {
            JButton button = new JButton(rightButtonsText[i]);
            button.setEnabled(false);
            JLabel label = new JLabel("no result");

            button.setPreferredSize(new Dimension(160, 25));
            label.setPreferredSize(new Dimension(60, 25));

            button.addActionListener(new ButtonActionListener(rightButtonLabelMap));
            rightButtonLabelMap.put(button, label);

            // button
            gbc.gridy = i;
            gbc.gridx = 0;
            rightButtonPanel.add(button, gbc);

            // label
            gbc.gridx = 1;
            rightButtonPanel.add(label, gbc);
        }

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

    static class ButtonActionListener implements ActionListener {
        private Map<JButton, JLabel> map;

        public ButtonActionListener(Map<JButton, JLabel> map) {
            this.map = map;
        }

        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton) e.getSource();
            JLabel label = map.get(button);
        }
    }

}