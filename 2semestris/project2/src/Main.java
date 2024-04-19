// 231RDB016, Milena Miloša, 10.grupa

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    final static String FILENAME = "db.csv";

    public static void main(String[] args) {
        String input;
        cycle: while (true) {
            input = sc.next();
            switch (input) {
                case "print":
                    print();
                    break;
                case "add":
                    String one = sc.nextLine().strip();
                    add(one);
                    break;
                case "edit":
                    String two = sc.nextLine().strip();
                    edit(two);
                    break;
                case "del":
                    int id = sc.nextInt();
                    del(id);
                    break;
                case "sort":
                    sort();
                    break;
                case "find":
                    try {
                        float limit = sc.nextFloat();
                        find(limit);
                    } catch (NoSuchElementException e) {
                        System.out.println("wrong price");
                    }
                    break;
                case "avg":
                    avg();
                    break;
                case "exit":
                    break cycle;
                default:
                    System.out.println("unknown e");
            }
        }
        sc.close();
    }

    public static void print() {
        ArrayList<String[]> data = new ArrayList<>();
        try {
            Scanner in = new Scanner(new FileInputStream(FILENAME));
            data = new ArrayList<>();
            boolean EOF = false;
            while (!EOF) {
                try {
                    data.add(in.nextLine().split(";"));
                } catch (NoSuchElementException e) {
                    EOF = true;
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        StringBuilder msg = new StringBuilder("------------------------------------------------------------\nID  City                   Date        Days  Price     Vehicle\n------------------------------------------------------------\n");

        for (String[] i : data) {
            msg.append(i[0]).append(" ".repeat(4 - i[0].length()));
            msg.append(i[1]).append(" ".repeat(21 - i[1].length()));
            msg.append(i[2]).append(" ".repeat(11 - i[2].length()));
            msg.append(" ".repeat(6 - i[3].length())).append(i[3]);
            msg.append(" ".repeat(10 - i[4].length())).append(i[4]);
            msg.append(" ").append(i[5]).append(" ".repeat(7 - i[5].length()));
            msg.append("\n");
        }
        msg.append("------------------------------------------------------------\n");

        System.out.println(msg);
    }

    public static void avg() {
        ArrayList<String[]> data = new ArrayList<>();
        try {
            Scanner in = new Scanner(new FileInputStream(FILENAME));
            data = new ArrayList<>();
            boolean EOF = false;
            while (!EOF) {
                try {
                    data.add(in.nextLine().split(";"));
                } catch (NoSuchElementException e) {
                    EOF = true;
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        int index = 0;
        float sum = 0;

        for (String[] i : data) {
            sum += Float.parseFloat(i[4]);
            index++;
        }
        System.out.printf("average=%.2f\n", sum/index);
    }

    public static void find(float limit) {
        ArrayList<String[]> data = new ArrayList<>();
        try {
            Scanner in = new Scanner(new FileInputStream(FILENAME));
            data = new ArrayList<>();
            boolean EOF = false;
            while (!EOF) {
                try {
                    data.add(in.nextLine().split(";"));
                } catch (NoSuchElementException e) {
                    EOF = true;
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ArrayList<String[]> filter = new ArrayList<>();
        for (String[] i : data) {
            if (Float.parseFloat(i[4]) <= limit) {
                filter.add(i);
            }
        }
        StringBuilder msg = new StringBuilder("------------------------------------------------------------\nID  City                   Date        Days  Price     Vehicle\n------------------------------------------------------------\n");

        for (String[] i : filter) {
            msg.append(i[0]).append(" ".repeat(4 - i[0].length()));
            msg.append(i[1]).append(" ".repeat(21 - i[1].length()));
            msg.append(i[2]).append(" ".repeat(11 - i[2].length()));
            msg.append(" ".repeat(6 - i[3].length())).append(i[3]);
            msg.append(" ".repeat(10 - i[4].length())).append(i[4]);
            msg.append(" ").append(i[5]).append(" ".repeat(7 - i[5].length()));
            msg.append("\n");
        }
        msg.append("------------------------------------------------------------\n");

        System.out.println(msg);
    }

    public static void del(int id) {
        if (id <= 100 || id > 999) {
            System.out.println("wrong id");
            return;
        }
        ArrayList<String[]> data = new ArrayList<>();
        try {
            Scanner in = new Scanner(new FileInputStream(FILENAME));
            data = new ArrayList<>();
            boolean EOF = false;
            while (!EOF) {
                try {
                    data.add(in.nextLine().split(";"));
                } catch (NoSuchElementException e) {
                    EOF = true;
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (String[] i : data) {
            if (Integer.parseInt(i[0]) == id) {
                data.remove(i);
                try {
                    PrintWriter out = new PrintWriter(FILENAME);
                    for (String[] j : data) {
                        out.println(String.join(";", j));
                    }
                    out.close();
                    System.out.println("deleted");
                    return;
                } catch (FileNotFoundException e) {
                    System.out.println("Error");
                    return;
                }
            }
        }
        System.out.println("wrong id");
    }

    public static void add(String line) {
        String[] separatedList = line.split(";", -1);
        String firstLetter = separatedList[1].substring(0, 1);
        String remainingLetters = separatedList[1].substring(1);
        firstLetter = firstLetter.toUpperCase();
        separatedList[1] = firstLetter + remainingLetters;

        if (separatedList.length != 6) {
            System.out.println("wrong field count");
            return;
        }
        try {
            if (Integer.parseInt(separatedList[0]) <= 100 || Integer.parseInt(separatedList[0]) > 999) {
                System.out.println("wrong id");
                return;
            }
        }
        catch (NumberFormatException e) {
            System.out.println("wrong id");
            return;
        }

        try {
            if (Integer.parseInt(separatedList[2].split("/")[0]) < 1 ||
                    Integer.parseInt(separatedList[2].split("/")[0]) > 31 ||
                    Integer.parseInt(separatedList[2].split("/")[1]) < 1 ||
                    Integer.parseInt(separatedList[2].split("/")[1]) > 12 ||
                    Integer.parseInt(separatedList[2].split("/")[2]) < 0) {
                System.out.println("wrong date");
                return;
            }
        }
        catch (NumberFormatException e) {System.out.println("wrong date");
            return;
        }

        try {
            Integer.valueOf(separatedList[3]);
        }
        catch (NumberFormatException e) {
            System.out.println("wrong day count");
            return;
        }

        try {
            separatedList[4] = String.format("%.2f", Float.valueOf(separatedList[4]));
        }
        catch (NumberFormatException e) {
            System.out.println("wrong price");
            return;
        }

        separatedList[5] = separatedList[5].toUpperCase().strip();
        if (!separatedList[5].equals("TRAIN") && !separatedList[5].equals("PLANE") &&
                !separatedList[5].equals("BUS") && !separatedList[5].equals("BOAT")) {
            System.out.println("wrong vehicle");
            return;
        }

        ArrayList<String[]> data;
        try {
            Scanner in = new Scanner(new FileInputStream(FILENAME));
            data = new ArrayList<>();
            boolean EOF = false;
            while (!EOF) {
                try {
                    data.add(in.nextLine().split(";"));
                } catch (NoSuchElementException e) {
                    EOF = true;
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        for (String[] i : data) {
            if (Integer.valueOf(separatedList[0]).equals(Integer.valueOf(i[0]))) {
            System.out.println("wrong id");
            return;
            }
        }

        data.add(separatedList);
        try {
            PrintWriter out = new PrintWriter(FILENAME);
            for (String[] j : data) {
                out.println(String.join(";", j));
            }
            out.close();
            System.out.println("added");
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

    }

    public static void edit(String line) {
        String[] separatedList = line.split(";", -1);
        String firstLetter = separatedList[1].substring(0, 1);
        String remainingLetters = separatedList[1].substring(1);
        firstLetter = firstLetter.toUpperCase();
        separatedList[1] = firstLetter + remainingLetters;

        if (separatedList.length != 6) {

            System.out.println("wrong field count");
            return;
        }
        try {
            if (Integer.parseInt(separatedList[0]) < 100 || Integer.parseInt(separatedList[0]) > 999) {
                System.out.println("wrong id");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("wrong id");
            return;
        }

        try {
            if (Integer.parseInt(separatedList[2].split("/")[0]) < 1 ||
                    Integer.parseInt(separatedList[2].split("/")[0]) > 31 ||
                    Integer.parseInt(separatedList[2].split("/")[1]) < 1 ||
                    Integer.parseInt(separatedList[2].split("/")[1]) > 12 ||
                    Integer.parseInt(separatedList[2].split("/")[2]) > 0) {
                System.out.println("wrong date");
                return;
            }
        }
        catch (NumberFormatException e) {System.out.println("wrong date");
            return;
        }

        if (!separatedList[3].isEmpty()) {
            try {
                Integer.valueOf(separatedList[3]);
            } catch (NumberFormatException e) {
                System.out.println("wrong day count");
                return;
            }
        }

        if (!separatedList[4].isEmpty()) {
            try {
                separatedList[4] = String.format("%.2f", Float.valueOf(separatedList[4]));
            } catch (NumberFormatException e) {
                System.out.println("wrong price");
                return;
            }
        }

        if (!separatedList[5].isEmpty()) {
            separatedList[5] = separatedList[5].toUpperCase().strip();
            if (!(separatedList[5].equals("TRAIN") || separatedList[5].equals("PLANE") || separatedList[5].equals("BUS") || separatedList[5].equals("BOAT"))) {
                System.out.println("wrong vehicle");
                return;
            }
        }

        ArrayList<String[]> data = new ArrayList<>();
        try {
            Scanner in = new Scanner(new FileInputStream(FILENAME));
            data = new ArrayList<>();
            boolean EOF = false;
            while (!EOF) {
                try {
                    data.add(in.nextLine().split(";"));
                } catch (NoSuchElementException e) {
                    EOF = true;
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        for (String[] i : data) {
            if (i[0].equals(separatedList[0])) {
                for (int j = 0; j < separatedList.length; j++) {
                    if (!separatedList[j].isEmpty()) {
                        i[j] = separatedList[j];
                    }
                }
                try {
                    PrintWriter out = new PrintWriter(FILENAME);
                    for (String[] j : data) {
                        out.println(String.join(";", j));
                    }
                    out.close();
                    System.out.println("changed");
                    return;
                } catch (FileNotFoundException e) {
                    System.out.println("Error");
                    return;
                }
            }
        }
        System.out.println("wrong id");
    }

    public static void sort() {
        ArrayList<String[]> data = new ArrayList<>();
        try {
            Scanner in = new Scanner(new FileInputStream(FILENAME));
            data = new ArrayList<>();
            boolean EOF = false;
            while (!EOF) {
                try {
                    data.add(in.nextLine().split(";"));
                } catch (NoSuchElementException e) {
                    EOF = true;
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        data.sort(Comparator.comparing(o -> LocalDate.parse(o[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        try {
            PrintWriter out = new PrintWriter(FILENAME);
            for (String[] j : data) {
                out.println(String.join(";", j));
            }
            out.close();
            System.out.println("sorted");
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
    }

}