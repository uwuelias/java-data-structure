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
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.awt.event.ActionEvent;

class wu_feng_p8 {
    private static int width = 700;
    private static int height = 350;

    private static String sortFile;
    private static String searchFile;

    private static JButton[] leftButtons = new JButton[9];
    private static JLabel[] leftLabels = new JLabel[9];
    private static JButton[] rightButtons = new JButton[9];
    private static JLabel[] rightLabels = new JLabel[9];

    private static ArrayList<Integer> sortInts = new ArrayList<>();
    private static ArrayList<Integer> searchInts = new ArrayList<>();

    private static TreeSet<Integer> bstTreeSet = new TreeSet<>();
    private static TreeSet<Integer> ts = new TreeSet<>();
    private static HashSet<Integer> hs = new HashSet<>();
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
    private static ArrayList<Integer> al = new ArrayList<>();
    private static ArrayList<Integer> al2 = new ArrayList<>();
    private static int[] arr;
    private static ArrayList<Integer> copyOfSortInts;

    private static void selectionSort() {
        int size = sortInts.size();
        int[] sortedArray = new int[size];

        for (int i = 0; i < size; i++) {
            sortedArray[i] = sortInts.get(i);
        }

        for (int i = 0; i < size - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < size; j++) {
                if (sortedArray[minIdx] > sortedArray[j]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                int temp = sortedArray[i];
                sortedArray[i] = sortedArray[minIdx];
                sortedArray[minIdx] = temp;
            }
        }
    }

    private static int searchIntsMethod() {
        int counter = 0;
        int size = sortInts.size();
        for (int x : searchInts) {
            int low = 0, high = size - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (sortInts.get(mid) == x) {
                    counter++;
                    break;
                }
                if (x < sortInts.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return counter;
    }

    private static void addToBinarySearchTree() {
        for (int x : sortInts) {
            bstTreeSet.add(x);
        }
    }

    private static int searchBinarySearchTree() {
        int counter = 0;
        for (int x : searchInts) {
            if (bstTreeSet.contains(x)) {
                counter++;
            }
        }

        return counter;
    }

    private static void addToTreeSet() {
        for (int x : sortInts) {
            ts.add(x);
        }
    }

    private static int searchTreeSet() {
        int counter = 0;
        for (int x : searchInts) {
            if (ts.contains(x)) {
                counter++;
            }
        }
        return counter;
    }

    private static void addToHashSet() {
        for (int x : sortInts) {
            hs.add(x);
        }
    }

    private static int searchHashSet() {
        int counter = 0;
        for (int x : searchInts) {
            if (hs.contains(x)) {
                counter++;
            }
        }
        return counter;

    }

    private static void addToPriorityQueue() {
        for (int x : sortInts) {
            pq.add(x);
        }
    }

    private static int searchPriorityQueue() {
        int counter = 0;
        for (int x : searchInts) {
            if (pq.contains(x)) {
                counter++;
            }
        }

        return counter;
    }

    private static void addToArrayList() {
        al.clear();
        for (int x : sortInts) {
            al.add(x);
        }
    }

    private static int searchArrayList() {
        int counter = 0;
        for (int x : searchInts) {
            if (al.contains(x)) {
                counter++;
            }
        }
        return counter;
    }

    private static void addToSortedArrayList() {
        al2.clear();
        for (int x : sortInts) {
            al2.add(x);
        }

        Collections.sort(al2);
    }

    private static int searchSortedArrayList() {
        int counter = 0;
        for (int x : searchInts) {
            if (Collections.binarySearch(al2, x) >= 0) {
                counter++;
            }
        }

        return counter;
    }

    private static void addToArray() {
        arr = new int[sortInts.size()];
        for (int i = 0; i < sortInts.size(); i++) {
            arr[i] = sortInts.get(i);
        }
    }

    private static int searchArray() {
        int counter = 0;
        for (int x : searchInts) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == x) {
                    counter++;
                    break;
                }
            }
        }

        return counter;
    }

    private static void mergeSort() {
        copyOfSortInts = sortInts;
        int n = sortInts.size();

        for (int size = 1; size < n; size *= 2) {
            for (int leftStart = 0; leftStart < n - size; leftStart += 2 * size) {
                int mid = Math.min(leftStart + size - 1, n - 1);
                int rightEnd = Math.min(leftStart + 2 * size - 1, n - 1);
                bottomUpMerge(copyOfSortInts, leftStart, mid, rightEnd);
            }
        }
    }

    private static void bottomUpMerge(ArrayList<Integer> list, int leftStart, int mid, int rightEnd) {
        int n1 = mid - leftStart + 1;
        int n2 = rightEnd - mid;

        ArrayList<Integer> leftArray = new ArrayList<>(list.subList(leftStart, leftStart + n1));
        ArrayList<Integer> rightArray = new ArrayList<>(list.subList(mid + 1, mid + n2 + 1));

        int i = 0, j = 0, k = leftStart;

        while (i < n1 && j < n2) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                list.set(k++, leftArray.get(i++));
            } else {
                list.set(k++, rightArray.get(j++));
            }
        }

        while (i < n1) {
            list.set(k++, leftArray.get(i++));
        }

        while (j < n2) {
            list.set(k++, rightArray.get(j++));
        }
    }

    private static void readData(String filename, boolean readSortValues) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;

            if (readSortValues) {
                while ((line = br.readLine()) != null) {
                    sortInts.add(Integer.parseInt(line));
                    for (JButton btn : leftButtons) {
                        btn.setEnabled(true);
                    }
                }
            } else {
                while ((line = br.readLine()) != null) {
                    searchInts.add(Integer.parseInt(line));
                    for (int i = 0; i < rightButtons.length; i++) {
                        if (!leftLabels[i].getText().equals("no result")) {
                            rightButtons[i].setEnabled(true);
                        }
                    }
                }
            }

            br.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static int searchMergeSortedInts() {
        int counter = 0;
        for (int x : searchInts) {
            int low = 0, high = copyOfSortInts.size() - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (copyOfSortInts.get(mid) == x) {
                    counter++;
                    break;
                }
                if (x < copyOfSortInts.get(mid)) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("invalid file input amount");
            System.exit(0);
        }
        sortFile = args[0];
        searchFile = args[1];

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
        GridBagLayout gridBagLayout = new GridBagLayout();
        leftButtonPanel.setLayout(gridBagLayout);
        leftButtonPanel.setMinimumSize(new Dimension(330, 350));
        leftButtonPanel.setPreferredSize(new Dimension(330, 350));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;
        gbc.weighty = 1;

        // initalize buttons for left button panel
        leftButtons[0] = new JButton("sort ints");
        leftButtons[1] = new JButton("add to bst");
        leftButtons[2] = new JButton("add to treeset");
        leftButtons[3] = new JButton("add to priority queue");
        leftButtons[4] = new JButton("add to hashset");
        leftButtons[5] = new JButton("add to arraylist");
        leftButtons[6] = new JButton("add to sorted arraylist");
        leftButtons[7] = new JButton("add to array");
        leftButtons[8] = new JButton("merge sort ints");

        // disable buttons on startup
        for (JButton button : leftButtons) {
            button.setEnabled(false);
        }

        // initialize labels for left button panel
        for (int i = 0; i < leftLabels.length; i++) {
            leftLabels[i] = new JLabel("no result");
        }

        // adding buttons and labels to left button panel
        for (int i = 0; i < leftButtons.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.gridwidth = 1;
            gridBagLayout.setConstraints(leftButtons[i], gbc);
            gbc.anchor = GridBagConstraints.LINE_START;
            leftButtonPanel.add(leftButtons[i], gbc);

            gbc.gridx = 1;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gridBagLayout.setConstraints(leftLabels[i], gbc);
            leftButtonPanel.add(leftLabels[i], gbc);
        }

        // button listener for left panel
        for (JButton b : leftButtons) {
            b.addActionListener(new ButtonActionListener(b));
        }

        JPanel rightButtonPanel = new JPanel();
        rightButtonPanel.setBorder(new LineBorder(Color.black, 2));
        GridBagLayout rightGridBagLayout = new GridBagLayout();
        rightButtonPanel.setLayout(rightGridBagLayout);
        rightButtonPanel.setMinimumSize(new Dimension(330, 350));
        rightButtonPanel.setPreferredSize(new Dimension(330, 350));

        // initalize buttons for right button panel
        JButton searchSortedInts = new JButton("search sorted ints");
        JButton searchBST = new JButton("search bst");
        JButton searchTreeSet = new JButton("search treeset");
        JButton searchPQ = new JButton("search priority queue");
        JButton searchHashset = new JButton("search hashset");
        JButton searchArraylist = new JButton("search arraylist");
        JButton searchSortedArraylist = new JButton("search sorted arraylist");
        JButton searchArray = new JButton("search array");

        rightButtons[0] = searchSortedInts;
        rightButtons[1] = searchBST;
        rightButtons[2] = searchTreeSet;
        rightButtons[3] = searchPQ;
        rightButtons[4] = searchHashset;
        rightButtons[5] = searchArraylist;
        rightButtons[6] = searchSortedArraylist;
        rightButtons[7] = searchArray;
        rightButtons[8] = new JButton("search merge sorted ints");

        // disable buttons upon startup;
        for (int i = 0; i < rightButtons.length; i++) {
            rightButtons[i].setEnabled(false);
        }

        // intalize labels for right button panel
        for (int i = 0; i < rightLabels.length; i++) {
            rightLabels[i] = new JLabel("no result");
        }

        // adding buttons and labels to right button panel
        for (int i = 0; i < leftButtons.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.gridwidth = 1;
            rightButtonPanel.add(rightButtons[i], gbc);
        }

        for (int i = 0; i < rightLabels.length; i++) {
            gbc.gridx = 1;
            gbc.gridy = i;
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            rightButtonPanel.add(rightLabels[i], gbc);
        }

        // adding action listener to right buttons
        for (JButton b : rightButtons) {
            b.addActionListener(new ButtonActionListener(b));
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

            String action = m.getText().toLowerCase();

            switch (action) {
                case "read sort file":
                    readData(sortFile, true);
                    break;

                case "read search file":
                    readData(searchFile, false);
                    break;

                case "exit":
                    System.exit(0);
                    break;
            }
        }
    }

    static class ButtonActionListener implements ActionListener {
        private JButton b;

        ButtonActionListener(JButton b) {
            this.b = b;
        }

        public void actionPerformed(ActionEvent e) {
            String action = b.getText().toLowerCase();
            long t0;
            long t1;
            int counter = 0;

            switch (action) {
                case "sort ints":
                    t0 = System.currentTimeMillis();
                    selectionSort();
                    t1 = System.currentTimeMillis();
                    leftLabels[0].setText(t1 - t0 + "ms");
                    System.out.println("working");
                    break;
                case "add to bst":
                    t0 = System.currentTimeMillis();
                    addToBinarySearchTree();
                    t1 = System.currentTimeMillis();
                    leftLabels[1].setText(t1 - t0 + "ms");
                    break;
                case "add to treeset":
                    t0 = System.currentTimeMillis();
                    addToTreeSet();
                    t1 = System.currentTimeMillis();
                    leftLabels[2].setText(t1 - t0 + "ms");
                    break;
                case "add to priority queue":
                    t0 = System.currentTimeMillis();
                    addToPriorityQueue();
                    t1 = System.currentTimeMillis();
                    leftLabels[3].setText(t1 - t0 + "ms");
                    break;
                case "add to hashset":
                    t0 = System.currentTimeMillis();
                    addToHashSet();
                    t1 = System.currentTimeMillis();
                    leftLabels[4].setText(t1 - t0 + "ms");
                    break;
                case "add to arraylist":
                    t0 = System.currentTimeMillis();
                    addToArrayList();
                    t1 = System.currentTimeMillis();
                    leftLabels[5].setText(t1 - t0 + "ms");
                    break;
                case "add to sorted arraylist":
                    t0 = System.currentTimeMillis();
                    addToSortedArrayList();
                    t1 = System.currentTimeMillis();
                    leftLabels[6].setText(t1 - t0 + "ms");
                    break;
                case "add to array":
                    t0 = System.currentTimeMillis();
                    addToArray();
                    t1 = System.currentTimeMillis();
                    leftLabels[7].setText(t1 - t0 + "ms");
                    break;
                case "merge sort ints":
                    t0 = System.currentTimeMillis();
                    mergeSort();
                    t1 = System.currentTimeMillis();
                    leftLabels[8].setText(t1 - t0 + "ms");
                    break;
                case "search sorted ints":
                    t0 = System.currentTimeMillis();
                    counter = searchIntsMethod();
                    t1 = System.currentTimeMillis();
                    rightLabels[0].setText(counter + " / " + (t1 - t0) + "ms");
                    break;
                case "search bst":
                    t0 = System.currentTimeMillis();
                    counter = searchBinarySearchTree();
                    t1 = System.currentTimeMillis();
                    rightLabels[1].setText(counter + " / " + (t1 - t0) + "ms");
                    break;
                case "search treeset":
                    t0 = System.currentTimeMillis();
                    counter = searchTreeSet();
                    t1 = System.currentTimeMillis();
                    rightLabels[2].setText(counter + " / " + (t1 - t0) + "ms");
                    break;
                case "search priority queue":
                    t0 = System.currentTimeMillis();
                    counter = searchPriorityQueue();
                    t1 = System.currentTimeMillis();
                    rightLabels[3].setText(counter + " / " + (t1 - t0) + "ms");
                    break;
                case "search hashset":
                    t0 = System.currentTimeMillis();
                    counter = searchHashSet();
                    t1 = System.currentTimeMillis();
                    rightLabels[4].setText(counter + " / " + (t1 - t0) + "ms");
                    break;
                case "search arraylist":
                    t0 = System.currentTimeMillis();
                    counter = searchArrayList();
                    t1 = System.currentTimeMillis();
                    rightLabels[5].setText(counter + " / " + (t1 - t0) + "ms");
                    break;
                case "search sorted arraylist":
                    t0 = System.currentTimeMillis();
                    counter = searchSortedArrayList();
                    t1 = System.currentTimeMillis();
                    rightLabels[6].setText(counter + " / " + (t1 - t0) + "ms");
                    break;
                case "search array":
                    t0 = System.currentTimeMillis();
                    counter = searchArray();
                    t1 = System.currentTimeMillis();
                    rightLabels[7].setText(counter + " / " + (t1 - t0) + "ms");
                    break;
                case "search merge sorted ints":
                    t0 = System.currentTimeMillis();
                    counter = searchMergeSortedInts();
                    t1 = System.currentTimeMillis();
                    rightLabels[8].setText(counter + " / " + (t1 - t0) + "ms");
                    break;
                default:
                    System.out.println("invalid button");
            }
        }
    }

}