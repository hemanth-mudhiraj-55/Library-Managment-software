package org.example;


import org.json.simple.JSONObject;
import java.awt.*;
import java.awt.event.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;


class Myframe  {

    public Myframe() {
        Label l1, l2;
        Button b1, b2;
        TextField t1, t2; // remove this later
        Frame ft;

        ft=new Frame("Library Login Page");
        ft.setVisible(true);


        ft.setSize(1920, 1080);
        l1 = new Label("The Central University of Rajasthan");
        l2 = new Label("Library");

        b1 = new Button("Administrator");
        b2 = new Button("User");
        Font f = new Font("Times New Roman", 1, 25);
        Font f1 = new Font("Times New Roman", 1, 60);

        b1.setFont(f);
        b2.setFont(f);
        l2.setFont(f1);
        l1.setFont(f1);
        ft.setLayout(null);
        l1.setBounds(320, 150, 1110, 100);
        l2.setBounds(700, 220, 300, 120);
        b1.setBounds(685, 415, 220, 50);
        b2.setBounds(685, 495, 220, 50);
        ft.add(l1);
        // add(t1);
        ft.add(l2);
        // add(t2);
        ft.add(b1);
        ft.add(b2);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Dash d = new Dash(ft);

            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User use=new User(ft);
                ft.setVisible(false);

            }
        });



        ft.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                ft.dispose();
            }
        });

    }

    // class Myevt implements ActionListener {
    // 	public void actionPerformed(ActionEvent e) {
    // 		t2.setText("");
    // 	}
    // }

}

class Dash  {

    public Dash(Frame ft) {

        Label l1, l0,l2;
        TextField t1, t2;
        Button b1, b2, b3;
        Frame f10;
        Checkbox c1;
        f10= new Frame("Admin Login page");
        ft.setVisible(false);
        f10.setVisible(true);




        f10.setSize(1920, 1080);
        l0 = new Label("**** ADMIN LOGIN PAGE ****");
        l1 = new Label("Username : ");
        l2 = new Label("Password : ");
        t1 = new TextField(20);
        t2 = new TextField(20);
        t2.setEchoChar('*');
        c1=new Checkbox("  show password");
        b1 = new Button("Login");
        b2 = new Button("Reset Password");
        b3 = new Button("Back");

        Font f = new Font("Times New Roman", 1, 25);
        Font f1 = new Font("Times New Roman", 1, 15);
        Font f2 = new Font("Times New Roman", 1, 32);

        b1.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f1);
        //c1.setFont(f1);
        l0.setFont(f2);
        l1.setFont(f);
        l2.setFont(f);

        f10.setLayout(null);

        l0.setBounds(570, 120, 700, 150);
        l1.setBounds(595, 265, 180, 50);
        t1.setBounds(795, 275, 220, 25);
        l2.setBounds(595, 335, 180, 50);
        t2.setBounds(795, 345, 220, 25);
        c1.setBounds(795, 375, 220, 25);
        b1.setBounds(595, 445, 200, 30);
        b2.setBounds(805, 445, 200, 30);
        b3.setBounds(1015, 595, 110, 30);

        f10.add(l1);
        f10.add(t1);
        f10.add(l2);
        f10.add(l0);
        f10.add(c1);
        f10.add(t2);
        f10.add(b1);
        f10.add(b2);
        f10.add(b3);

        c1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e)
            {
                // Handling Checkbox state change event
                if (c1.getState()) {
                    t2.setEchoChar((char)0);
                }
                else {
                    t2.setEchoChar('*');
                }
            }
        });

        //reading
        JSONParser jsonParser = new JSONParser();
        String admin_username="";
        String admin_password="";
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/admin_login_details.json"));
            admin_username=(String) jsonObject.get("Id");
            admin_password=(String) jsonObject.get("Password");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String finalAdmin_username = admin_username;
        String finalAdmin_password = admin_password;

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t1.getText().equals(finalAdmin_username) && t2.getText().equals(finalAdmin_password)) {
                    Admin_login a = new Admin_login(ft);
                    f10.setVisible(false);
                }
                else {
                    String msg="Entered username or password is \ninvalid";
                    message_popup mes= new message_popup(msg);

                }
            }
        });


        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Admin_password_reset ap = new Admin_password_reset( f10);

                f10.setVisible(false);

            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ft.setVisible(true);
                f10.setVisible(false);

            }
        });

        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });
    }

}


class Admin_login  {

    public Admin_login(Frame ft) {

        Button b1, b2, b3, b4, b5,b6;
        Frame f10=new Frame("Admin Operations");
        f10.setVisible(true);


        f10.setSize(1920, 1080);
        b1 = new Button("Add Books");
        b2 = new Button("Edit Book Library");
        b3 = new Button("Delete Books");
        b6=new Button("Search Book");
        b4 = new Button("More");
        b5 = new Button("Back");

        Font f = new Font("Times New Roman", 1, 25);
        Font f1 = new Font("Times New Roman", 1, 15);

        b1.setFont(f);
        b2.setFont(f);
        b3.setFont(f);
        b4.setFont(f);
        b6.setFont(f);
        b5.setFont(f1);

        f10.setLayout(null);

        b6.setBounds(665, 225, 290, 50);
        b1.setBounds(665, 295, 290, 50);
        b2.setBounds(665, 365, 290, 50);
        b3.setBounds(665, 435, 290, 50);
        b4.setBounds(665, 505, 290, 50);

        f10.add(b1);
        f10.add(b2);
        f10.add(b3);
        f10.add(b4);
        f10.add(b5);
        f10.add(b6);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Add_books addd = new Add_books(f10);
                f10.setVisible(false);

            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Edit_book edt = new Edit_book(f10);
                f10.setVisible(false);

            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Delete_book del = new Delete_book(f10);
                f10.setVisible(false);

            }
        });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                more etc = new more(f10);
                f10.setVisible(false);

            }
        });

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ft.setVisible(true);
                f10.setVisible(false);
            }
        });
        b6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               search_book sc= new search_book(f10);
            }
        });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });

    }
}

class Add_books  {
    String Book_name;
    String Author_name;
    String Publisher_name;
    String book_category;
    String temp;
    Integer initial_copies;


    public Add_books(Frame ft) {
        TextField t1, t2, t3, t4, t5;
        Label l1,l0, l2, l3, l4, l5;
        Button b1, b2;
        Frame f10=new Frame("Add books");
        f10.setVisible(true);



        f10.setSize(1920, 1080);

        l0 = new Label("*** ADD BOOK DETAILS ***");
        l1 = new Label("Book Title");
        l2 = new Label("Author");
        l3 = new Label("Publisher");
        l4 = new Label("Book category");
        l5 = new Label("No.of copies");

        t1 = new TextField(20);
        t2 = new TextField(20);
        t3 = new TextField(20);
        t4 = new TextField(20);
        t5 = new TextField(20);

        b1 = new Button("Submit");
        b2 = new Button("Back");

        Font f = new Font("Times New Roman", 1, 25);
        Font f1 = new Font("Times New Roman", 1, 15);
        Font f2 = new Font("Times New Roman", 1, 30);

        b1.setFont(f);
        b2.setFont(f1);

        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l0.setFont(f2);

        f10.setLayout(null);

        l0.setBounds(585, 120, 700, 100);
       // l1.setBounds(515, 240, 200, 50);
        l1.setBounds(515, 240, 200, 50);
        l2.setBounds(515, 310, 200, 50);
        l3.setBounds(515, 380, 200, 50);
        l4.setBounds(515, 450, 200, 50);
        l5.setBounds(515, 520, 200, 50);

        t1.setBounds(715, 245, 290, 35);
        t2.setBounds(715, 315, 290, 35);
        t3.setBounds(715, 385, 290, 35);
        t4.setBounds(715, 455, 290, 35);
        t5.setBounds(715, 525, 290, 35);




        b1.setBounds(715, 655, 110, 50);
        b2.setBounds(1195, 755, 110, 30);

        f10.add(l1);
        f10.add(l2);
        f10.add(l3);
        f10.add(l4);
        f10.add(l5);
        f10.add(l0);

        f10.add(b1);
        f10.add(b2);

        f10.add(t1);
        f10.add(t2);
        f10.add(t3);
        f10.add(t4);
        f10.add(t5);




        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Book_name = t1.getText();
                Author_name = t2.getText();
                Publisher_name = t3.getText();
                book_category = t4.getText();
                temp=t5.getText();
                int check=0;
                if(temp.length()==0){
                    initial_copies=0;

                    String msg="Entered invalid details";
                    message_popup mes= new message_popup(msg);
                    check=1;
                }
                else{
                    try {
                        initial_copies = Integer.parseInt(temp);
                    } catch (Exception klj) {
                        String msg="Entered invalid No.of copies\n        Re-enter copies ";
                        message_popup mes= new message_popup(msg);
                        check=1;
                    }

                }


                if(Book_name.length()>0 && Author_name.length()>0 && Publisher_name.length()>0 && book_category.length()>0 && check==0 ) {

                    double temp = 0;
                    String temp_book_code;
                    String temp_String_store = "";
                    String temparary;

                    for (int i = 0; i < book_category.length(); i++) {
                        temp += (double) book_category.charAt(i);
                    }
                    temp_book_code = Double.toString(temp);
                    temp_book_code = temp_book_code.substring(0, 3);
                    temp_String_store = temp_book_code.concat(".");


                    for (int i = 0; i < Book_name.length(); i++) {
                        temp += (double) Book_name.charAt(i);
                    }
                    temp_book_code = Double.toString(temp);
                    temp_book_code = temp_book_code.substring(0, 3);
                    temparary = Book_name.substring(0, 1);
                    temp_String_store = temp_String_store.concat(temp_book_code);
                    temp_String_store = temp_String_store.concat(temparary + ".");


                    for (int i = 0; i < Author_name.length(); i++) {
                        temp += (double) Author_name.charAt(i);
                    }
                    temp_book_code = Double.toString(temp);
                    temp_book_code = temp_book_code.substring(0, 3);
                    temparary = Author_name.substring(0, 1);
                    temp_String_store = temp_String_store.concat(temp_book_code);
                    temp_String_store = temp_String_store.concat(temparary);

                    JSONParser jsonParser = new JSONParser();
                    String uid = "";

                    int j = 1;

                    try {
                        JSONArray userarray = (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json"));
                        for (int i = 0; i < userarray.toArray().length; i++) {
                            JSONObject temp_user = (JSONObject) userarray.get(i);

                            uid = (String) temp_user.get("Book-id");

                            if (temp_String_store.equals(uid)) {
                                j = 0;
                            }
                        }
                        if (j == 0) {
                            String msd="Entered details already exist";
                            message_popup msg= new message_popup(msd);
                        }

                    } catch (Exception erp) {

                    }


                    if (j == 1) {
                        try {
                            // database db= new database(Book_name,Author_name,Publisher_name,book_category,initial_copies,temp_String_store);
                            jsondatabase jdb = new jsondatabase(Book_name, Author_name, Publisher_name, book_category, initial_copies, temp_String_store);
                            String msg = "Book details are sucessfully saved\n Generated Book-id :" + temp_String_store;
                            message_popup msd = new message_popup(msg);
                            t1.setText("");
                            t2.setText("");
                            t3.setText("");
                            t4.setText("");
                            t5.setText("");
                        } catch (Exception database_exception) {


                        }

                    }
                }


            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ft.setVisible(true);
                f10.setVisible(false);

            }
        });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });

    }

}
class  Edit_book{
    String Book_name;
    String Author_name;
    String Publisher_name;
    String book_category;
    String temp;
    Long initial_copies;
    String ide;


    Edit_book(Frame f45){


            TextField t1,t6, t2, t3, t4, t5;
            Label l1,l0,l6, l2, l3, l4, l5;
            Button b1,b3, b2;
            Frame f10=new Frame("Edit books");
            f10.setVisible(true);



            f10.setSize(1920, 1080);

            l1 = new Label("Book Title");
            l2 = new Label("Author");
            l3 = new Label("Publisher");
            l4 = new Label("Book category");
            l5 = new Label("Present copies");
            l0=new Label("*** EDIT BOOK DETAILS ***");
            l6=new Label("Enter Book Id : ");

            t1 = new TextField(20);
            t2 = new TextField(20);
            t3 = new TextField(20);
            t4 = new TextField(20);
            t5 = new TextField(20);
            t6 = new TextField(15);

            b1 = new Button("Enter");
            b2 = new Button("Back");
            b3 = new Button("Submit");

            Font f = new Font("Times New Roman", 1, 25);
            Font f1 = new Font("Times New Roman", 1, 15);
            Font f13 = new Font("Times New Roman", 1, 30);

            b1.setFont(f1);
            b2.setFont(f1);
            b3.setFont(f);

            l1.setFont(f);
            l2.setFont(f);
            l3.setFont(f);
            l4.setFont(f);
            l5.setFont(f);
            l6.setFont(f1);
            l0.setFont(f13);

            f10.setLayout(null);

            l0.setBounds(565, 120, 700, 100);
            l6.setBounds(565, 230, 120, 50);
            l1.setBounds(515, 310, 200, 50);
            l2.setBounds(515, 380, 200, 50);
            l3.setBounds(515, 450, 200, 50);
            l4.setBounds(515, 520, 200, 50);
            l5.setBounds(515, 590, 200, 50);

        // t1.setBounds(715, 245, 290, 35);
            t1.setBounds(715, 315, 290, 35);
            t2.setBounds(715, 385, 290, 35);
            t3.setBounds(715, 455, 290, 35);
            t4.setBounds(715, 525, 290, 35);
            t5.setBounds(715, 595, 290, 35);
            t6.setBounds(705, 240, 210, 30);



            b1.setBounds(945, 237, 80, 30);
            b2.setBounds(1195, 755, 110, 30);
            b3.setBounds(715, 655, 110, 50);

            f10.add(l1);
            f10.add(l2);
            f10.add(l3);
            f10.add(l4);
            f10.add(l5);
            f10.add(l0);
            f10.add(l6);

            f10.add(b1);
            f10.add(b2);
            f10.add(b3);

            f10.add(t1);
            f10.add(t2);
            f10.add(t3);
            f10.add(t4);
            f10.add(t5);
            f10.add(t6);



        JSONParser jsonParser = new JSONParser();
        final int[] k = new int[1];

            b1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String uid=t6.getText();
                    String Id;
                    int o=0;
                    try{
                        JSONArray userarray= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json"));
                        for(int i=0;i<userarray.toArray().length;i++){
                            JSONObject temp_user= (JSONObject) userarray.get(i);
                            Id=(String) temp_user.get("Book-id");
                            Book_name=(String) temp_user.get("Book Title");
                            Author_name=(String) temp_user.get("Author");
                            Publisher_name=(String) temp_user.get("Publisher");
                            book_category=(String) temp_user.get("Book category");
                            initial_copies=(Long) temp_user.get("Present copies");
                            temp= Long.toString(initial_copies);
                            if(Id.equals(uid)){
                                k[0] =i;
                                ide=Id;

                                t1.setText(Book_name);
                                t2.setText(Author_name);
                                t3.setText(Publisher_name);
                                t4.setText(book_category);
                                t5.setText(temp);
                                o=1;

                            }
                        }
                        if(o==0){
                            String msg="      Book Id doesn't exist";
                            message_popup msd=new message_popup(msg);
                        }

                    }
                    catch (Exception erp){
                        erp.printStackTrace();

                    }



                }
            });
            b2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    f45.setVisible(true);
                    f10.setVisible(false);

                }
            });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Book_name=t1.getText();
                Author_name=t2.getText();
                Publisher_name= t3.getText();
                book_category= t4.getText();
                temp=t5.getText();
                initial_copies=Long.parseLong(temp);

                String uid=t6.getText();
                String Id;
                try{
                    JSONArray userarray= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json"));


                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");

                    String msg="Details are Sucessfully edited";
                    message_popup msf= new message_popup(msg);
                    ((JSONObject) userarray.get(k[0])).put("Book Title",Book_name);
                    ((JSONObject) userarray.get(k[0])).put("Author",Author_name);
                    ((JSONObject) userarray.get(k[0])).put("Publisher",Publisher_name);
                    ((JSONObject) userarray.get(k[0])).put("Book category",book_category);
                    ((JSONObject) userarray.get(k[0])).put("Present copies",initial_copies);

                    try {
                        FileWriter file = new FileWriter("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json");
                        file.write(userarray.toJSONString());
                        file.close();
                    } catch (IOException e56) {
                        e56.printStackTrace();
                    }

                }
                catch (Exception erp){
                    erp.printStackTrace();

                }




            }
        });
            f10.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    f10.dispose();
                }
            });

        }


}
class search_book{//need database do later
    public search_book(Frame ft){

        Frame f10=new Frame("Search Bar");
        Label l1,l0,l2;
        Choice c1;
        TextField t1;
        Button b1,b2,b3;


        Font f = new Font("Times New Roman", 1, 13);
        Font f5 = new Font("Times New Roman", 1, 30);
        t1=new TextField(100);
        TextArea ta1=new TextArea(2,2);
        ta1.setFont(f);

        f10.add(ta1);

        l1=new Label("Search");
        l0=new Label("*** SEARCH BOOK DETAILS ***");

        c1=new Choice();
        b1=new Button("Enter");
        b2=new Button("Back");
        b3=new Button("Clear Search");

        l1.setFont(f);
        l0.setFont(f5);
        b1.setFont(f);
        b2.setFont(f);
        b3.setFont(f);


        f10.setVisible(true);
        f10.setSize(1920, 1080);
        f10.setLayout(null);

        c1.add("Select");
        c1.add("Book name");
        c1.add("Book id");
        c1.add("Author name");
        c1.add("Category");



        ta1.setBounds(300,290,1000,300);
        l0.setBounds(560, 120, 700, 100);
        l1.setBounds(270,220,70,30);
        c1.setBounds(290,225,230,60);
        t1.setBounds(540,220,550,30);
        b1.setBounds(1100,220,70,30);
        b2.setBounds(195, 755, 110, 30);
        b3.setBounds(1190, 220, 110, 30);
        //f10.add(l1);
        f10.add(l0);
        f10.add(c1);
        f10.add(t1);
        f10.add(b3);
        f10.add(b1);
        f10.add(b2);




        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String search=t1.getText();
                String Book_name;
                String Author_name;
                String Id;
                String book_category;
                Long present_copies;

                if(c1.getSelectedItem().equals("Select")){
                    String msg="Please Choose searching criteria";
                    message_popup msd=new message_popup(msg);
                }
                if(c1.getSelectedItem().equals("Book name")){
                    search sc=new search(ta1,search,"Book Title");
                }
                if(c1.getSelectedItem().equals("Book id")){
                    search sc=new search(ta1,search,"Book-id");
                }
                if(c1.getSelectedItem().equals("Author name")){
                    search sc=new search(ta1,search,"Author");
                }
                if(c1.getSelectedItem().equals("Category")){
                    search sc=new search(ta1,search,"Book category");
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ft.setVisible(true);
                f10.setVisible(false);

            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               ta1.selectAll();
               ta1.setText("");

            }
        });




        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });

    }
}
class original_edit{
    original_edit(){

    }
}
class search{
    String Book_name;
    String Author_name;
    String Id;
    String book_category;
    Long present_copies;
    String key;
    int k=0;
    search(TextArea ta1,String search,String choice){

        JSONParser jsonParser = new JSONParser();

        int j=1;
        try{
            JSONArray userarray= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json"));
            for(int i=0;i<userarray.toArray().length;i++){
                JSONObject temp_user= (JSONObject) userarray.get(i);

                Book_name=(String) temp_user.get("Book Title");
                Author_name=(String) temp_user.get("Author");
                Id=(String) temp_user.get("Book-id");
                book_category=(String) temp_user.get("Book category");
                present_copies=(Long) temp_user.get("Present copies");
                if(choice.equals("Book Title")){
                    key=Book_name;
                }
                if(choice.equals("Author")){
                    key=Author_name;
                }
                if(choice.equals("Book-id")){
                    key=Id;
                }
                if(choice.equals("Book category")){
                    key=book_category;
                }
                if(search.equals(key)){
                    ta1.append ("Book Id                   : " + (String) temp_user.get("Book-id") + "\n");
                    ta1.append ("Book Title              : " + (String) temp_user.get("Book Title") + "\n");
                    ta1.append ("Author                    : " + (String) temp_user.get("Author") + "\n");
                    ta1.append ("Category                : " + (String) temp_user.get("Book category")+ "\n");
                    ta1.append ("Available copies  : " + (Long) temp_user.get("Present copies")+ "\n");
                    ta1.append("\n\n");
                    k=1;
                }
            }

        }
        catch (Exception erp){
            erp.printStackTrace();
            System.out.println("error");

        }
        if(k==0){
            String msd="      Book not found";
            message_popup msg=new message_popup(msd);
        }
        original_edit og= new original_edit();
    }
}
class edit_database{
    edit_database(String search,String choice){


    }
}
class Delete_book  {//need database do later

    String Book_name;
    String Author_name;
    String Publisher_name;
    String book_category;
    String temp;
    Long initial_copies;
    String ide;

    Delete_book(Frame f45){


        TextField t1,t6, t2, t3, t4, t5;
        Label l1,l0,l6, l2, l3, l4, l5;
        Button b1,b3, b2;
        Frame f10=new Frame("Delete Book");
        f10.setVisible(true);



        f10.setSize(1920, 1080);

        l1 = new Label("Book Title");
        l2 = new Label("Author");
        l3 = new Label("Publisher");
        l4 = new Label("Book category");
        l5 = new Label("Present copies");
        l0=new Label("*** DELETE BOOK DETAILS ***");
        l6=new Label("Enter Book Id : ");

        t1 = new TextField(20);
        t2 = new TextField(20);
        t3 = new TextField(20);
        t4 = new TextField(20);
        t5 = new TextField(20);
        t6 = new TextField(15);

        b1 = new Button("Enter");
        b2 = new Button("Back");
        b3 = new Button("Confirm to Delete");

        Font f = new Font("Times New Roman", 1, 25);
        Font f1 = new Font("Times New Roman", 1, 15);
        Font f13 = new Font("Times New Roman", 1, 30);

        b1.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f);

        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f1);
        l0.setFont(f13);

        f10.setLayout(null);

        l0.setBounds(560, 120, 700, 100);
        l6.setBounds(565, 230, 120, 50);
        l1.setBounds(515, 310, 200, 50);
        l2.setBounds(515, 380, 200, 50);
        l3.setBounds(515, 450, 200, 50);
        l4.setBounds(515, 520, 200, 50);
        l5.setBounds(515, 590, 200, 50);

        // t1.setBounds(715, 245, 290, 35);
        t1.setBounds(715, 315, 290, 35);
        t2.setBounds(715, 385, 290, 35);
        t3.setBounds(715, 455, 290, 35);
        t4.setBounds(715, 525, 290, 35);
        t5.setBounds(715, 595, 290, 35);
        t6.setBounds(705, 240, 210, 30);



        b1.setBounds(945, 237, 80, 30);
        b2.setBounds(1195, 755, 110, 30);
        b3.setBounds(695, 655, 230, 45);

        f10.add(l1);
        f10.add(l2);
        f10.add(l3);
        f10.add(l4);
        f10.add(l5);
        f10.add(l0);
        f10.add(l6);

        f10.add(b1);
        f10.add(b2);
        f10.add(b3);

        f10.add(t1);
        f10.add(t2);
        f10.add(t3);
        f10.add(t4);
        f10.add(t5);
        f10.add(t6);



        JSONParser jsonParser = new JSONParser();
        final int[] k = new int[1];

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String uid=t6.getText();
                String Id;
                int o=0;
                try{
                    JSONArray userarray= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json"));
                    for(int i=0;i<userarray.toArray().length;i++){
                        JSONObject temp_user= (JSONObject) userarray.get(i);
                        Id=(String) temp_user.get("Book-id");
                        Book_name=(String) temp_user.get("Book Title");
                        Author_name=(String) temp_user.get("Author");
                        Publisher_name=(String) temp_user.get("Publisher");
                        book_category=(String) temp_user.get("Book category");
                        initial_copies=(Long) temp_user.get("Present copies");
                        temp= Long.toString(initial_copies);
                        if(Id.equals(uid)){
                            k[0] =i;
                            ide=Id;

                            t1.setText(Book_name);
                            t2.setText(Author_name);
                            t3.setText(Publisher_name);
                            t4.setText(book_category);
                            t5.setText(temp);
                            o=1;


                        }
                    }
                    if(o==0){
                        String msg="      Book Id doesn't exist";
                        message_popup msd=new message_popup(msg);
                    }


                }
                catch (Exception erp){
                    erp.printStackTrace();

                }



            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f45.setVisible(true);
                f10.setVisible(false);

            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
              try{
                    JSONArray userarray= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json"));
                    userarray.remove(k[0]);
                    try {
                        FileWriter file = new FileWriter("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json");
                        file.write(userarray.toJSONString());
                        file.close();
                    } catch (IOException e56) {
                        e56.printStackTrace();
                    }
                }
                catch (Exception erp){
                    erp.printStackTrace();
                }
            }
        });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });

    }
}
class more  {

    public more(Frame ft) {

        Button b1,b2, b3,b4, b5;
        Label l0;
        Frame f10=new Frame("More Settings");
        f10.setVisible(true);


        f10.setSize(1920, 1080);
        b1 = new Button("Change mail id");
        b3 = new Button("Change login details");
        b4 = new Button("Borrowed books report");
        b2 = new Button("User Details Check");
        b5 = new Button("Back");
        l0= new Label("*** MORE SETTINGS ***");

        Font f = new Font("Times New Roman", 1, 25);
        Font f2 = new Font("Times New Roman", 1, 30);
        Font f1 = new Font("Times New Roman", 1, 15);
        b1.setFont(f);
        l0.setFont(f2);
        b3.setFont(f);
        b2.setFont(f);
        b4.setFont(f);
        b5.setFont(f1);

        f10.setLayout(null);

        b1.setBounds(605, 295, 370, 50);
        b3.setBounds(605, 365, 370, 50);
        b4.setBounds(605, 435, 370, 50);
        b2.setBounds(605, 505, 370, 50);
        l0.setBounds(600, 120, 700, 120);
        b5.setBounds(1015, 595, 110, 30);

        f10.add(b1);
        f10.add(l0);
        f10.add(b3);
        f10.add(b5);
        f10.add(b2);
        f10.add(b4);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mail_id mail= new mail_id(f10);
                f10.setVisible(false);

            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Change_Login_details cha= new Change_Login_details(f10);
                f10.setVisible(false);

            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Borrowed_books_report bp=new Borrowed_books_report(f10);
                f10.setVisible(false);

            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Frame f;
                TextField t11;
                Label l1;
                Button b1;
                f=new Frame("User Details ");
                f.setLocation(550,300);
                f.setVisible(true);
                f.setSize(450,150);
                Font f1 = new Font("Times New Roman", 1, 15);
                f.setLayout(null);
                l1= new Label("Enter UID : ");
                t11=new TextField(12);
                b1=new Button("ok");
                l1.setFont(f1);
                b1.setFont(f1);
                l1.setBounds(90,70,90,20);
                t11.setBounds(190,70,100,20);
                b1.setBounds(330,70,30,25);
                f.add(l1);
                f.add(t11);
                f.add(b1);
                f.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent we) {
                        f.dispose();
                    }
                });
                b1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                       String UID= t11.getText();
                        JSONParser jsonParser1=new JSONParser();
                        try{
                            JSONArray userarray= (JSONArray) jsonParser1.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/userdata.json"));
                            for(int i=0;i<userarray.toArray().length;i++){
                                JSONObject temp_user= (JSONObject) userarray.get(i);
                                String user= (String) temp_user.get("UID");
                                if (user.equals(UID)) {
                                    f.setVisible(false);
                                    Account_details xc= new Account_details(f10,UID);


                                }

                            }
                        }
                        catch (Exception erp){
                        }
                    }
                });

            }
        });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ft.setVisible(true);
                f10.setVisible(false);
            }
        });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });

    }
}
class
Borrowed_books_report{
    Borrowed_books_report(Frame ft){
        Button b1,b2;
        Label l0,l1;
        TextField t1;

        Frame f10=new Frame("Borrowed_books_report");
        f10.setVisible(true);


        f10.setSize(1920, 1080);
        b1 = new Button("Back");
        b2 = new Button("Enter");
        l0= new Label("*** BORROWED BOOKS REPORT ***");
        t1=new TextField(20);
        l1=new Label("Enter Book ID : ");

        Font f = new Font("Times New Roman", 1, 25);
        Font f2 = new Font("Times New Roman", 1, 30);
        Font f1 = new Font("Times New Roman", 1, 15);
        b1.setFont(f);
        b2.setFont(f1);
        t1.setFont(f1);
        l1.setFont(f1);
        l0.setFont(f2);

        f10.setLayout(null);

        l0.setBounds(510, 120, 750, 80);
        b1.setBounds(355, 595, 110, 30);
        b2.setBounds(850, 230, 110, 30);
        l1.setBounds(530, 230, 150, 30);
        t1.setBounds(690, 230, 200, 30);


        f10.add(b1);
        f10.add(l0);
        f10.add(b2);
        f10.add(l1);
        f10.add(t1);


        TextArea ta1;
        ta1= new TextArea(2,2);
        ta1.setFont(f1);
        //ta1.setBounds(620,180,4);
        ta1.setBounds(550, 300, 480, 550);
        f10.add(ta1);

        JSONParser jsonParser1=new JSONParser();
        try{
            JSONArray userarray= (JSONArray) jsonParser1.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/book_borrow.json"));
            ta1.append(" *** TOTAL BOOKS BORROW RECORD ***\n\n");
            for(int i=0;i<userarray.toArray().length;i++){
                JSONObject temp_user= (JSONObject) userarray.get(i);


                ta1.append("UID    : "+((String) temp_user.get("UID"))+"\n");
                Set<String> x=temp_user.keySet();
                x.remove("Count");
               x.remove("UID");
                Iterator<String> namesIterator = x.iterator();
                int p=0;
                String hp;
                while (p<x.size()) {
                    hp=namesIterator.next();
                    ta1.append("Book Id   : "+hp+"  -->>  ");
                    ta1.append(" Due Date: "+(String) temp_user.get(hp)+"\n");
                    p++;
                }
                ta1.append("\n");


            }
        }
        catch (Exception erp){
        }



        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               ft.setVisible(true);
                f10.setVisible(false);

            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bid_temp=t1.getText();
                JSONParser jsonParser2=new JSONParser();
                ta1.append("\n *** BORROWERS OF BOOK WITH ID : "+bid_temp+" *** \n");
                int t=0;
                try{
                    JSONArray userarray2= (JSONArray) jsonParser2.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/book_borrow.json"));
                    for(int i=0;i<userarray2.toArray().length;i++){
                        JSONObject temp_user2= (JSONObject) userarray2.get(i);



                        Set<String> x=temp_user2.keySet();
                        x.remove("Count");
                        Iterator<String> namesIterator = x.iterator();
                        int p=0;

                        String hp;
                        while (p<x.size()) {
                            hp=namesIterator.next();

                            if (hp.equals(bid_temp)) {
                                ta1.append("UID    : "+((String) temp_user2.get("UID"))+"  -->>  ");
                                ta1.append(" Due Date: "+(String) temp_user2.get(hp)+"\n");
                                t=1;
                            }

                            p++;
                        }

                    }
                    if(t==0){
                        ta1.append("No results Found ...!!!");
                    }
                    ta1.append("\n");
                }
                catch (Exception erp){
                }


            }
        });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });
    }

}
class Change_Login_details{
    Change_Login_details(Frame ft){
        Label l1, l0,l2,l3;
        TextField t1, t2,t3;
        Button  b2, b3;
        Frame f10;
        Checkbox c1;
        f10= new Frame("Change login details");
        ft.setVisible(false);
        f10.setVisible(true);




        f10.setSize(1920, 1080);
        l0 = new Label("**** CHANGE LOGIN DETAILS ****");
        l1 = new Label("New Username :");
        l2 = new Label("Password : ");
        l3 = new Label("Re-entre Password : ");
        t1 = new TextField(23);
        t2 = new TextField(23);
        t3 = new TextField(23);
        t2.setEchoChar('*');
        t3.setEchoChar('*');
        c1=new Checkbox("  show password");
       // b1 = new Button("Login");
        b2 = new Button("Submit");
        b3 = new Button("Back");

        Font f = new Font("Times New Roman", 1, 25);
        Font f1 = new Font("Times New Roman", 1, 15);
        Font f2 = new Font("Times New Roman", 1, 32);


        b2.setFont(f1);
        b3.setFont(f1);
        //c1.setFont(f1);
        l0.setFont(f2);
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);

        f10.setLayout(null);

        l0.setBounds(570, 120, 700, 150);
        l1.setBounds(595, 265, 250, 50);
        t1.setBounds(865, 275, 250, 25);
        l2.setBounds(595, 335, 180, 50);
        l3.setBounds(595, 405, 260, 50);
        t2.setBounds(865, 345, 250, 25);
        t3.setBounds(865, 415, 250, 25);
        c1.setBounds(865, 445, 220, 25);
      //  b1.setBounds(675, 445, 110, 30);
        b2.setBounds(795, 515, 110, 35);
        b3.setBounds(1015, 595, 110, 30);

        f10.add(l1);
        f10.add(t1);
        f10.add(l2);
        f10.add(l0);
        f10.add(c1);
        f10.add(t2);
        //f10.add(b1);
        f10.add(b2);
        f10.add(b3);
        f10.add(l3);
        f10.add(t3);

        c1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e)
            {
                // Handling Checkbox state change event
                if (c1.getState()) {
                    t2.setEchoChar((char)0);
                    t3.setEchoChar((char)0);
                }
                else {
                    t2.setEchoChar('*');
                    t3.setEchoChar('*');
                }
            }
        });


        JSONParser jsonParser = new JSONParser();
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String pass= t2.getText();
               String p2= t3.getText();
               String un=t1.getText();
               if(un.length()>3){
               if(pass.equals(p2)){

                   try {
                       JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/admin_login_details.json"));
                       jsonObject.put("Id",un);
                       jsonObject.put("Password",pass);
                       try {
                           FileWriter file = new FileWriter("C:/Users/heman/OneDrive/Desktop/CIA2project/json/admin_login_details.json");
                           file.write(jsonObject.toJSONString());
                           file.close();
                           String msg="Admin Login details are updated successfully";
                           message_popup msd=new message_popup(msg);
                           t1.setText("");
                           t2.setText("");
                           t3.setText("");
                       } catch (IOException e56) {
                           e56.printStackTrace();
                       }
                   }
                   catch (Exception es){
                       es.printStackTrace();
                   }


               }
               else {
                   String msg="Entered Mis-matching passwords";
                   message_popup msd= new message_popup(msg);
               }
               }
               else {
                   String msg="Enter Strong username";
                   message_popup msd= new message_popup(msg);

               }

            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ft.setVisible(true);
                f10.setVisible(false);

            }
        });

        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });

    }

}
class mail_id{
    String id;
    String passwod;
    public mail_id(Frame f){
        Frame f10;
        Panel p1,p2;
        TextField t1,t2;
        Label l1,l2,l3;
        Button b2,b3;
        Checkbox c1;


        JSONParser jsonParser1 = new JSONParser();

        try {
            JSONObject jsonObject = (JSONObject) jsonParser1.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/admin_login_details.json"));
            String admin_mail=(String) jsonObject.get("Mail-id");
           String admin_password=(String) jsonObject.get("MailPassword");
           id=admin_mail;
           passwod=admin_password;
        }
        catch (Exception e){
            e.printStackTrace();
        }


        f10= new Frame("MailId");
        f10.setVisible(true);
        f10.setSize(1920,1080);

        p1= new Panel();
        p2= new Panel();
        c1=new Checkbox("show password");

        t1=new TextField(20);
        t2=new TextField(20);
        t2.setEchoChar('*');

        l1= new Label("Mail-id");
        l2=new Label("Password");
        l3=new Label("Change Mail-id");


        b2=new Button("Back");
        b3=new Button("Next");

        Font f1 = new Font("Times New Roman", 1, 15);
        Font f2 = new Font("Times New Roman", 1, 25);
        l3.setFont(f2);
        l1.setFont(f1);
        l2.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f1);


        f10.setLayout(null);
        p1.setLayout(null);
        p2.setBackground(Color.darkGray);

        p1.setBounds(600,200,350,450);
        p2.setBounds(599,199,352,452);

        l1.setBounds(650,350,90,20);
        t1.setBounds(750,350,170,20);
        l2.setBounds(650,400,90,20);
        t2.setBounds(750,400,170,20);
        c1.setBounds(730,430,170,20);
        b2.setBounds(650,550,60,20);
        b3.setBounds(850,550,60,20);
        l3.setBounds(690,260,180,30);
        //l1.setBounds(599,199,352,452);

        f10.add(l1);
        f10.add(l2);
        f10.add(l3);
        f10.add(c1);
        f10.add(b2);
        f10.add(b3);
        f10.add(t1);
        f10.add(t2);
        f10.add(p1);
        f10.add(p2);
        c1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e)
            {
                // Handling Checkbox state change event
                if (c1.getState()) {
                    t2.setEchoChar((char)0);
                }
                else {
                    t2.setEchoChar('*');
                }
            }
        });
        //back
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.setVisible(true);
                f10.setVisible(false);

            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (t1.getText().equals(id) && t2.getText().equals(passwod)) {
                    Change_admin_mail mail=new Change_admin_mail(f,f10);
                    f10.setVisible(false);
                }
                else {
                    String msg="Entered username or password is \ninvalid";
                    message_popup mes= new message_popup(msg);
                }
            }
        });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });


    }
}
class Change_admin_mail{
    String un;
    String pass;
    public Change_admin_mail(Frame f,Frame f0){
        Frame f10;
        Panel p1,p2;
        TextField t1,t2;
        Label l1,l2,l3;
        Button b2,b3;
        Checkbox c1;


        f10= new Frame("Update Mail Id");
        f10.setVisible(true);
        f10.setSize(1920,1080);

        p1= new Panel();
        p2= new Panel();
        c1=new Checkbox("show password");

        t1=new TextField(20);
        t2=new TextField(20);
        t2.setEchoChar('*');

        l1= new Label("Original Mail-Id");
        l2=new Label("Original Password");
        l3=new Label("*** MAIL-ID UPDATION ***");


        b2=new Button("Back");
        b3=new Button("Submit");

        Font f1 = new Font("Times New Roman", 1, 15);
        Font f2 = new Font("Times New Roman", 1, 25);
        l3.setFont(f2);
        l1.setFont(f1);
        l2.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f1);


        f10.setLayout(null);
        p1.setLayout(null);
        p2.setBackground(Color.darkGray);

        p1.setBounds(600,200,350,450);
        p2.setBounds(599,199,352,452);

        l1.setBounds(610,350,135,20);
        t1.setBounds(760,350,170,20);
        l2.setBounds(610,400,135,20);
        t2.setBounds(760,400,170,20);
        c1.setBounds(760,430,170,20);
        b2.setBounds(650,550,60,20);
        b3.setBounds(850,550,60,20);
        l3.setBounds(620,260,315,30);
        //l1.setBounds(599,199,352,452);

        f10.add(l1);
        f10.add(l2);
        f10.add(l3);
        f10.add(c1);
        f10.add(b2);
        f10.add(b3);
        f10.add(t1);
        f10.add(t2);
        f10.add(p1);
        f10.add(p2);
        c1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e)
            {
                // Handling Checkbox state change event
                if (c1.getState()) {
                    t2.setEchoChar((char)0);
                }
                else {
                    t2.setEchoChar('*');
                }
            }
        });
        //back
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f0.setVisible(true);
                f10.setVisible(false);

            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                un= t1.getText();
                pass=t2.getText();
                JSONParser jsonParser= new JSONParser();
                try {
                    JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/admin_login_details.json"));
                    jsonObject.put("Mail-id",un);
                    jsonObject.put("MailPassword",pass);
                    try {
                        FileWriter file = new FileWriter("C:/Users/heman/OneDrive/Desktop/CIA2project/json/admin_login_details.json");
                        file.write(jsonObject.toJSONString());
                        file.close();
                        String msg="Admin Login details are updated successfully";
                        message_popup msd=new message_popup(msg);
                        t1.setText("");
                        t2.setText("");
                    } catch (IOException e56) {
                        e56.printStackTrace();
                    }
                }
                catch (Exception es){
                    es.printStackTrace();
                }



            }
        });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });


    }
}

class Admin_password_reset  {


    public Admin_password_reset(Frame f0) {
        Frame f10;
        Panel p1,p2;
        TextField t1,t2;
        Label l1,l2,l3;
        Button b1,b2,b3;



        f10= new Frame("Password Reset");
        f10.setVisible(true);
        f10.setSize(1920,1080);

        p1= new Panel();
        p2= new Panel();

        t1=new TextField(20);
        t2=new TextField(20);
        t2.setEchoChar('*');

        l1= new Label("Mail-Id");
         l2=new Label("OTP");
        l3=new Label("*** PASSWORD RESET ***");

        b1=new Button("Enter");
        b2=new Button("Back");
        b3=new Button("Submit");

        Font f1 = new Font("Times New Roman", 1, 15);
        Font f2 = new Font("Times New Roman", 1, 25);
        l3.setFont(f2);
        l1.setFont(f1);
        l2.setFont(f1);
        b1.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f1);


        f10.setLayout(null);
        p1.setLayout(null);
        p2.setBackground(Color.darkGray);

        p1.setBounds(600,200,350,450);
        p2.setBounds(599,199,352,452);

        l1.setBounds(650,350,50,20);
        t1.setBounds(710,350,170,20);
        b1.setBounds(745,390,70,20);
        l2.setBounds(650,430,50,20);
        t2.setBounds(710,430,170,20);
        b3.setBounds(745,470,70,20);
        b2.setBounds(650,550,70,20);
        l3.setBounds(625,260,315,30);
        //l1.setBounds(599,199,352,452);

        f10.add(l1);
        f10.add(l2);
        f10.add(b1);
        f10.add(l3);
        f10.add(b2);
        f10.add(b3);
        f10.add(t1);
        f10.add(t2);
        f10.add(p1);
        f10.add(p2);

        JSONParser jsonParser = new JSONParser();
        String admin_mail="";
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/admin_login_details.json"));
            admin_mail=(String) jsonObject.get("Mail-id");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Random rand= new Random();
        long otp = rand.nextInt(1000000);
        String finalAdmin_mail = admin_mail;

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String temp_mail;
                temp_mail= t1.getText();
                if(temp_mail.equals(finalAdmin_mail)){


                    String message = "The verification code for gmail is "+Long.toString(otp);


                    Mailsender ms=new Mailsender(finalAdmin_mail,"2020btcse013@curaj.ac.in","Sumanth@321",message);
                    ms.start();
                    counter c=new counter();
                    int k=ms.check();
                    if(k==1){
                        String msg="Network issue araised....";
                        message_popup mg=new message_popup(msg);
                    }

                }
                else{
                    String msg="Entered admin mail-id is wrong";
                    message_popup mg=new message_popup(msg);
                }

            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String temp_otp=t2.getText();
                String temp2= Long.toString(otp);
                if(temp_otp.equals(temp2)){
                    Change_Login_details cd= new Change_Login_details(f10);
                    f10.setVisible(false);
                    System.out.println(temp_otp);
                    System.out.println(otp);

                }
                else{
                    String msg="Entered OTP is wrong";
                    message_popup ms= new message_popup(msg);
                }


            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f0.setVisible(true);
                f10.setVisible(false);
            }
        });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });


    }
}
class User{

    User(Frame f){
        Frame f10;
        Panel p1,p2;
        TextField t1,t2;
        Label l1,l2,l3,l4,l5;
        Button b1,b2,b3,b4,b5;
        Checkbox c1;


        f10= new Frame("Home Page");
        f10.setVisible(true);
        f10.setSize(1920,1080);

//        p1= new Panel();
//        p2= new Panel();
        c1=new Checkbox("show password");

        t1=new TextField(20);
        t2=new TextField(20);
        t2.setEchoChar('*');

        l4 = new Label("The Central University of Rajasthan");
        l5 = new Label("Library");
        l1= new Label("Username");
        l2=new Label("Password");
        l3=new Label("*** USER LOGIN PAGE ***");


        b1=new Button("?Forgetpassword");
        b4=new Button("Sign up");
        b2=new Button("Back");
        b5=new Button("Search Book");
        b3=new Button("Next");

        Font f1 = new Font("Times New Roman", 1, 15);
        Font f2 = new Font("Times New Roman", 1, 30);
        Font f3 = new Font("Times New Roman", 1, 25);
        Font f7 = new Font("Times New Roman", 1, 60);

        l3.setFont(f2);
        l1.setFont(f1);
        l4.setFont(f7);
        l5.setFont(f7);
        l2.setFont(f1);
        b4.setFont(f1);
        b2.setFont(f3);
        b3.setFont(f1);
        b5.setFont(f3);


        f10.setLayout(null);

        l4.setBounds(320, 100, 1110, 100);
        l5.setBounds(700, 170, 300, 120);
        l1.setBounds(650,400,90,20);
        t1.setBounds(750,400,170,20);
        l2.setBounds(650,450,90,20);
        t2.setBounds(750,450,170,20);
        c1.setBounds(750,480,170,20);
        b1.setBounds(650,520,120,20);
        b2.setBounds(200,720,85,40);
        b5.setBounds(1100,720,255,40);
        b4.setBounds(650,580,65,25);
        b3.setBounds(850,580,65,25);
        l3.setBounds(610,330,400,30);

        f10.add(l1);
        f10.add(l2);
        f10.add(l3);
        f10.add(l4);
        f10.add(l5);
        f10.add(c1);
        f10.add(b4);
        f10.add(b2);
        f10.add(b3);
        f10.add(b5);
        f10.add(t1);
        f10.add(t2);

      c1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e)
            {
                // Handling Checkbox state change event
                if (c1.getState()) {
                    t2.setEchoChar((char)0);
                }
                else {
                    t2.setEchoChar('*');
                }
            }
        });

        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                User_signup snup=new User_signup(f10);
                f10.setVisible(false);

            }
        });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                search_book sc= new search_book(f10);
                f10.setVisible(false);

            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JSONParser jsonParser = new JSONParser();
                String username="";
                String password="";
                int j=1;
                try{
                    JSONArray userarray= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/User_login_details.json"));
                    for(int i=0;i<userarray.toArray().length;i++){
                        JSONObject temp_user= (JSONObject) userarray.get(i);

                        username= (String) temp_user.get("Id");
                        password= (String) temp_user.get("Password");

                        if (t1.getText().equals(username) && t2.getText().equals(password)) {
                            t1.setText("");
                            t2.setText("");
                            User_next uxt= new User_next(f10,username);
                            f10.setVisible(false);
                            j=0;
                        }
                    }

                }
                catch (Exception erp){

                }
                if(j==1) {
                    String msg="Login details not exist";
                    message_popup mes= new message_popup(msg);
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Back_admin bak= new Back_admin(f,f10);
                f10.setVisible(false);
            }
        });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });

    }
}
class User_next{
    User_next(Frame ft,String UID){
        Button b1, b2, b3, b4, b5;
        Frame f10=new Frame("3rd");
        f10.setVisible(true);
        Label l3;


        f10.setSize(1920, 1080);

        b2 = new Button("Borrow book");
        b3 = new Button("Return book");
        b4 = new Button("Account details");
        b5 = new Button("Back");
        l3= new Label("*** USER CHIOCES ***");


        Font f = new Font("Times New Roman", 1, 25);
        Font f1 = new Font("Times New Roman", 1, 15);
        Font f2 = new Font("Times New Roman", 1, 30);

        b2.setFont(f);
        b3.setFont(f);
        b4.setFont(f);
        b5.setFont(f1);
        l3.setFont(f2);

        f10.setLayout(null);

        b2.setBounds(665, 295, 290, 50);
        b3.setBounds(665, 365, 290, 50);
        b4.setBounds(665, 435, 290, 50);
        b5.setBounds(1015, 595, 110, 30);
        l3.setBounds(650,200,400,30);

        f10.add(b2);
        f10.add(b3);
        f10.add(b4);
        f10.add(b5);
        f10.add(l3);

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Borrow_book bar= new Borrow_book(f10,UID);
                f10.setVisible(false);
            }
        });
        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f10.setVisible(false);
                ft.setVisible(true);
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Return_book rb= new Return_book(f10,UID);
                f10.setVisible(false);
            }
        });
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Account_details ac=new Account_details(f10,UID);
               f10.setVisible(false);
            }
        });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });
    }
}
class Borrow_book{
    String Book_name;
    String Author_name;
    String Publisher_name;
    String book_category;
    String temp;
    Long initial_copies;
    String ide;
    String user_mail_id;
    String admin_mail;
    String admin_password;
    String user_name;
    String book_uid;
    long holdings;
    long count1;
    Borrow_book(Frame f45,String UID){
        TextField t1,t6, t2, t3, t4, t5;
        Label l1,l0,l6, l2, l3, l4, l5;
        Button b1,b3, b2;
        Frame f10=new Frame("Borrow books page");
        f10.setVisible(true);
        f10.setSize(1920, 1080);

        l1 = new Label("Book Title");
        l2 = new Label("Author");
        l3 = new Label("Publisher");
        l4 = new Label("Book category");
        l5 = new Label("Present copies");
        l0=new Label("*** BORROW BOOKS ***");
        l6=new Label("Enter Book Id : ");

        t1 = new TextField(20);
        t2 = new TextField(20);
        t3 = new TextField(20);
        t4 = new TextField(20);
        t5 = new TextField(20);
        t6 = new TextField(15);

        b1 = new Button("Enter");
        b2 = new Button("Back");
        b3 = new Button("Confirm to Borrow");

        Font f = new Font("Times New Roman", 1, 25);
        Font f1 = new Font("Times New Roman", 1, 15);
        Font f13 = new Font("Times New Roman", 1, 30);

        b1.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f);

        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f1);
        l0.setFont(f13);

        f10.setLayout(null);

        l0.setBounds(580, 120, 700, 100);
        l6.setBounds(565, 230, 120, 50);
        l1.setBounds(515, 310, 200, 50);
        l2.setBounds(515, 380, 200, 50);
        l3.setBounds(515, 450, 200, 50);
        l4.setBounds(515, 520, 200, 50);
        l5.setBounds(515, 590, 200, 50);

        t1.setBounds(715, 315, 290, 35);
        t2.setBounds(715, 385, 290, 35);
        t3.setBounds(715, 455, 290, 35);
        t4.setBounds(715, 525, 290, 35);
        t5.setBounds(715, 595, 290, 35);
        t6.setBounds(705, 240, 210, 30);

        b1.setBounds(945, 237, 80, 30);
        b2.setBounds(1195, 755, 110, 30);
        b3.setBounds(695, 655, 230, 45);

        f10.add(l1);
        f10.add(l2);
        f10.add(l3);
        f10.add(l4);
        f10.add(l5);
        f10.add(l0);
        f10.add(l6);

        f10.add(b1);
        f10.add(b2);
        f10.add(b3);

        f10.add(t1);
        f10.add(t2);
        f10.add(t3);
        f10.add(t4);
        f10.add(t5);
        f10.add(t6);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime issused_date = LocalDateTime.now();
        LocalDateTime return_date = LocalDateTime.now().plusDays(15);

        String issued_date=formatter.format(issused_date);
        String rtn_date=formatter.format(return_date);

        JSONParser jsonParser1 = new JSONParser();

        try {
            JSONObject jsonObject = (JSONObject) jsonParser1.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/admin_login_details.json"));
            admin_mail=(String) jsonObject.get("Mail-id");
            admin_password=(String) jsonObject.get("MailPassword");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        final int[] k = new int[1];

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JSONParser jsonParser = new JSONParser();
                book_uid=t6.getText();
                String Id;
                int o=0;
                try{
                    JSONArray userarray= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json"));
                    for(int i=0;i<userarray.toArray().length;i++){
                        JSONObject temp_user= (JSONObject) userarray.get(i);
                        Id=(String) temp_user.get("Book-id");

                        if(Id.equals(book_uid)){
                            k[0] =i;
                            ide=Id;
                            Id=(String) temp_user.get("Book-id");
                            Book_name=(String) temp_user.get("Book Title");
                            Author_name=(String) temp_user.get("Author");
                            Publisher_name=(String) temp_user.get("Publisher");
                            book_category=(String) temp_user.get("Book category");
                            initial_copies=(Long) temp_user.get("Present copies");
                            temp= Long.toString(initial_copies);

                            t1.setText(Book_name);
                            t2.setText(Author_name);
                            t3.setText(Publisher_name);
                            t4.setText(book_category);
                            t5.setText(temp);
                            o=1;
                        }
                    }
                    if(o==0){
                        String msg="      Book Id doesn't exist";
                        message_popup msd=new message_popup(msg);
                    }
                }
                catch (Exception erp){
                    erp.printStackTrace();
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f45.setVisible(true);
                f10.setVisible(false);
            }
        });
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int temp2=Integer.parseInt(temp);
                int j=1;

                if (temp2>0) {
                    JSONObject jsonObject = new JSONObject();
                    JSONParser jsonParser = new JSONParser();
                    JSONArray jsonArrayUser = new JSONArray();
                    String username;

                    try{
                        JSONArray userarray= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/book_borrow.json"));
                        for(int i=0;i<userarray.toArray().length;i++){
                            JSONObject temp_user= (JSONObject) userarray.get(i);

                            username= (String) temp_user.get("UID");
                             count1=(Long) temp_user.get("Count");



                            int temp69=1000;
                            try{String temp967= (String) temp_user.get(book_uid);
                                temp967=temp967.substring(0,2);
                                temp69=Integer.parseInt(temp967);}
                            catch (Exception ert){
                            }


                            if (UID.equals(username)) {
                                if(count1<5) {
                                    if(temp69==1000) {
                                        count1++;
                                        holdings= count1;
                                        temp_user.put("Count", count1);
                                        temp_user.put(ide, rtn_date);



                                        try {
                                            FileWriter file = new FileWriter("C:/Users/heman/OneDrive/Desktop/CIA2project/json/book_borrow.json");
                                            file.write(userarray.toJSONString());
                                            file.close();
                                        } catch (IOException e56) {
                                            e56.printStackTrace();
                                        }

                                        String msag = "Dear " + user_name + "\n The book with title '" + Book_name + "' is issued on your ID: " + UID + "\n Due date of book to return is : " + rtn_date + "\n\n Thank for Borrowing books from Library";
                                        Mailsender ms = new Mailsender(user_mail_id, admin_mail, admin_password, msag);
                                        ms.start();
                                    }
                                    else {
                                        String msg="This book can,t be issued on your id\nBecause you have the same copy of it";
                                        message_popup msd= new message_popup(msg);
                                    }
                                }
                                else{
                                    String msg="Already "+count1+" books are issued on your id";
                                    message_popup mg=new message_popup(msg);
                                }
                                j=4;
                            }

                        }
                        if(j==1){
                            System.out.println("this is borr");
                            try (FileReader reader = new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/book_borrow.json")) {
                                Object obj = jsonParser.parse(reader);
                                if (obj instanceof JSONArray) {
                                    jsonArrayUser = (JSONArray) obj;
                                } else if (obj instanceof JSONObject) {
                                    // If the parsed object is a JSONObject, add it to the JSONArray
                                    jsonArrayUser.add(obj);
                                }
                            } catch (Exception erp) {
                                System.out.println("90");
                                erp.printStackTrace();
                            }
                            count1=1;
                            holdings=count1;

                            jsonObject.put("UID",UID);
                            jsonObject.put("Count",count1);
                            jsonObject.put(ide,rtn_date);

                            jsonArrayUser.add(jsonObject);

                            try {
                                FileWriter file = new FileWriter("C:/Users/heman/OneDrive/Desktop/CIA2project/json/book_borrow.json");
                                file.write(jsonArrayUser.toJSONString());
                                file.close();
                            } catch (IOException e45) {

                            }
                            j=5;


                        }
                        System.out.println(j);
                        if(j==4 || j==5){
                            try{
                                JSONArray userarray2= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json"));
                                for(int i=0;i<userarray2.toArray().length;i++){
                                    JSONObject temp_user= (JSONObject) userarray2.get(i);
                                    String Id=(String) temp_user.get("Book-id");
                                    long il_copies=(Long) temp_user.get("Present copies");
                                    long bar_copies=(Long) temp_user.get("Borrowed copies");

                                    il_copies--;
                                    bar_copies++;

                                    String mag="Book is successfully borrowed";
                                    message_popup mp= new message_popup(mag);


                                    try{
                                        JSONArray userarray4= (JSONArray) jsonParser1.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/userdata.json"));
                                        for(int h=0;h<userarray4.toArray().length;h++){
                                            JSONObject temp_user4= (JSONObject) userarray4.get(h);

                                            String user_mail= (String) temp_user4.get("Email-id");
                                            String user= (String) temp_user4.get("UID");

                                            if (user.equals(UID)) {
                                                user_mail_id=user_mail;
                                                user_name=(String) temp_user4.get("Name");
                                                temp_user4.put("holdings",holdings);
                                                try {
                                                    FileWriter file = new FileWriter("C:/Users/heman/OneDrive/Desktop/CIA2project/json/userdata.json");
                                                    file.write(userarray4.toJSONString());
                                                    file.close();
                                                } catch (IOException e45) {

                                                }
                                            }
                                        }
                                    }
                                    catch (Exception erp){
                                    }

                                    String msag="Dear "+user_name+" the book with title '"+Book_name+"' is issued on your\nID: "+UID+"\n Due date of book to return is : "+rtn_date+"\n\n Thank for Borrowing books from Library";
                                    Mailsender ms=new Mailsender(user_mail_id,admin_mail,admin_password,msag);
                                    ms.start();

                                    t1.setText("");
                                    t2.setText("");
                                    t3.setText("");
                                    t4.setText("");
                                    t5.setText("");
                                    t6.setText("");

                                    if(Id.equals(book_uid)){
                                        temp_user.put("Present copies",il_copies);
                                        temp_user.put("Borrowed copies",bar_copies);
                                        try {
                                            FileWriter file = new FileWriter("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json");
                                            file.write(userarray2.toJSONString());
                                            file.close();
                                        } catch (IOException e56) {
                                            e56.printStackTrace();
                                        }

                                    }
                                }
                            }
                            catch (Exception erp){
                                erp.printStackTrace();

                            }
                        }
                    }
                    catch (Exception erp){
                        System.out.println("error");
                    }
                }
                else{
                    String msg="This book cannot be borrowed\nBecause '0' copies available";
                    message_popup msd=new message_popup(msg);
                }
            }
        });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });


    }
}
class update_holdings{
    update_holdings(){}
}
class Return_book{

    String issuedate;
    String book_ids;
    long diff;
    long fine;
    String admin_password;
    String admin_mail;
    String user_mail_id;
    String user_name;
    String book_name;
    long holdings;
    Return_book(Frame ft,String UID){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime today_date = LocalDateTime.now();
        String return_date=formatter.format(today_date);

        System.out.println(return_date);

        JSONParser jsonParser1 = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser1.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/admin_login_details.json"));
            admin_mail=(String) jsonObject.get("Mail-id");
            admin_password=(String) jsonObject.get("MailPassword");
        }
        catch (Exception e){
            e.printStackTrace();
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try{
            Date firstDate = sdf.parse(return_date);
            Date secondDate = sdf.parse(issuedate);
            long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
            diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        }
        catch (Exception e){}

        if(diff<16){
            fine=0;
        }
        else if(diff>15){
            fine =diff-15;
        }

        TextField t6;
        Label l0,l6;
        Button b1,b3, b2;
        Frame f10=new Frame("4th");
        f10.setVisible(true);

        try{
            JSONArray userarray= (JSONArray) jsonParser1.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/userdata.json"));
            for(int i=0;i<userarray.toArray().length;i++){
                JSONObject temp_user= (JSONObject) userarray.get(i);

                String user_mail= (String) temp_user.get("Email-id");
                String user= (String) temp_user.get("UID");

                if (user.equals(UID)) {
                    user_mail_id=user_mail;
                    user_name=(String) temp_user.get("Name");
                    temp_user.put("Fine",fine);
                    temp_user.put("holdings",holdings);
                    try {
                        FileWriter file = new FileWriter("C:/Users/heman/OneDrive/Desktop/CIA2project/json/userdata.json");
                        file.write(userarray.toJSONString());
                        file.close();
                    } catch (IOException e56) {
                        e56.printStackTrace();
                    }
                }
            }
        }
        catch (Exception erp){
        }

        f10.setSize(1920, 1080);

        l0=new Label("*** BOOK RETURN PAGE ***");
        l6=new Label("Enter Book Id : ");

        t6 = new TextField(15);

        b1 = new Button("Enter");
        b2 = new Button("Back");
        b3 = new Button("Confirm to Return");

        Font f = new Font("Times New Roman", 1, 25);
        Font f1 = new Font("Times New Roman", 1, 15);
        Font f13 = new Font("Times New Roman", 1, 30);

        TextArea ta1=new TextArea(2,2);
        ta1.setFont(f1);
        f10.add(ta1);

        b1.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f);

        l6.setFont(f1);
        l0.setFont(f13);

        f10.setLayout(null);

        l0.setBounds(560, 120, 700, 100);
        l6.setBounds(565, 230, 120, 50);
        ta1.setBounds(600, 300, 400, 300);
        t6.setBounds(705, 240, 210, 30);
        b1.setBounds(945, 237, 80, 30);
        b2.setBounds(1195, 755, 110, 30);
        b3.setBounds(695, 655, 230, 45);

        f10.add(l0);
        f10.add(l6);

        f10.add(b1);
        f10.add(b2);
        f10.add(b3);
        f10.add(t6);

        JSONParser jsonParser = new JSONParser();
        final int[] k = new int[1];

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String temp_book_id= t6.getText();

                try{
                    JSONArray userarray= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/book_borrow.json"));
                    for(int i=0;i<userarray.toArray().length;i++){
                        JSONObject temp_user= (JSONObject) userarray.get(i);

                        String temp_uid= (String) temp_user.get("UID");

                        int temp69=1000;

                        try{String temp967= (String) temp_user.get(temp_book_id);
                            issuedate=temp967;
                            temp967=temp967.substring(0,2);
                            temp69=Integer.parseInt(temp967);}
                        catch (Exception ert){

                        }
                        if (temp_uid.equals(UID) && temp69<1000) {
                            JSONParser jsonParser = new JSONParser();
                            int j=1;
                            try{
                                JSONArray userarray2= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json"));
                                for(int k=0;k<userarray2.toArray().length;k++){

                                    JSONObject temp1_user= (JSONObject) userarray2.get(k);
                                    String temp_bird= (String) temp1_user.get("Book-id");
                                    if (temp_book_id.equals(temp_bird)) {
                                        book_ids=temp_bird;
                                        ta1.append ("Book due date      :"+issuedate+"\n");
                                        ta1.append ("Book Id                   : " + (String) temp1_user.get("Book-id") + "\n");
                                        ta1.append ("Book Title              : " + (String) temp1_user.get("Book Title") + "\n");
                                        ta1.append ("Author                    : " + (String) temp1_user.get("Author") + "\n");
                                        ta1.append ("Category                : " + (String) temp1_user.get("Book category")+ "\n");
                                        ta1.append ("Available copies  : " + (Long) temp1_user.get("Present copies")+ "\n");
                                        ta1.append("Fine on book        :"+" Rs: "+fine);
                                        ta1.append("\n\n");
                                    }
                                }

                            }
                            catch (Exception erp){
                                System.out.println("error 1");
                            }
                        }
                        else{
                            String msg="This book is not issued on this id\n     UID : "+UID;
                            message_popup msf=new message_popup(msg);
                        }
                    }

                }
                catch (Exception erp){
                    System.out.println("error");
                }
            }
        });
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ft.setVisible(true);
                f10.setVisible(false);
            }
        });
        final int[] kl = new int[1];
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    JSONArray userarray2= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json"));
                    for(int i=0;i<userarray2.toArray().length;i++){
                        JSONObject temp_user= (JSONObject) userarray2.get(i);
                        String Id=(String) temp_user.get("Book-id");

                        long il_copies=(Long) temp_user.get("Present copies");
                        long bar_copies=(Long) temp_user.get("Borrowed copies");

                        il_copies++;
                        bar_copies--;
                        if(Id.equals(book_ids)) {
                            kl[0] =i;
                            temp_user.put("Present copies", il_copies);
                            temp_user.put("Borrowed copies", bar_copies);
                            book_name=(String) temp_user.get("Book Title");
                            try {
                                FileWriter file = new FileWriter("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json");
                                file.write(userarray2.toJSONString());
                                file.close();
                            } catch (IOException e56) {
                                e56.printStackTrace();
                            }
                        }
                    }
                }
                catch (Exception erp){
                    erp.printStackTrace();

                }

                try{
                    JSONArray userarray3= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/book_borrow.json"));
                    for(int i=0;i<userarray3.toArray().length;i++){
                        JSONObject temp_user= (JSONObject) userarray3.get(i);

                        String temp_uid= (String) temp_user.get("UID");
                        long count= (Long) temp_user.get("Count");

                        int temp69=1000;

                        try{String temp967= (String) temp_user.get(book_ids);
                            issuedate=temp967;
                            temp967=temp967.substring(0,2);
                            temp69=Integer.parseInt(temp967);}
                        catch (Exception ert){
                        }

                        System.out.println(book_ids);
                        if (temp_uid.equals(UID) && temp69<1000) {

                            JSONArray userarray2= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json"));
                            JSONObject temp89_user= (JSONObject) userarray2.get(k[0]);
                            if(count>1){
                                holdings=count--;
                                temp89_user.remove(book_ids);
                                temp89_user.put("Count",count);
                            }
                            else if (count<=1) {
                                temp89_user.remove(kl[0]);
                            }
                        }
                        try {
                            t6.setText("");
                            String msg="Book is sucessfully retured";
                            message_popup msd=new message_popup(msg);

                            String msag = "Dear " + user_name + "\n The book with title '" + book_name + "' is sucessfully retured with  UID: " + UID +  "\n\n Thank for Borrowing books from Library";
                            Mailsender ms = new Mailsender(user_mail_id, admin_mail, admin_password, msag);
                            ms.start();

                            FileWriter file = new FileWriter("C:/Users/heman/OneDrive/Desktop/CIA2project/json/book_borrow.json");
                            file.write(userarray3.toJSONString());
                            file.close();
                        } catch (IOException e56) {
                            e56.printStackTrace();
                        }
                    }
                }
                catch (Exception erp){
                    System.out.println("error");
                }
            }
        });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });

    }
}
class Account_details{
    Account_details(Frame ft,String temp_user_id){
        TextField t6;
        Label l0,l6;
        Button b1,b3, b2;
        Frame f10=new Frame("4th");
        f10.setVisible(true);

        f10.setSize(1920, 1080);

        l0=new Label("*** USER ACCOUNT DETAILS ***");
        b2 = new Button("Back");


        Font f1 = new Font("Times New Roman", 1, 15);
        Font f13 = new Font("Times New Roman", 1, 30);

        TextArea ta1=new TextArea(2,2);
        ta1.setFont(f1);
        f10.add(ta1);

        b2.setFont(f1);
        l0.setFont(f13);

        f10.setLayout(null);

        l0.setBounds(560, 120, 700, 100);
        ta1.setBounds(600, 300, 400, 300);
        b2.setBounds(1195, 755, 110, 30);
        f10.add(l0);
        f10.add(b2);

        JSONParser jsonParser = new JSONParser();
        int j=1;
        try{
            JSONArray userarray2= (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/userdata.json"));
            for(int k=0;k<userarray2.toArray().length;k++){

                JSONObject temp1_user= (JSONObject) userarray2.get(k);
                String temp_bird= (String) temp1_user.get("UID");
                if (temp_user_id.equals(temp_bird)) {
                    ta1.append ("USERNAME       : "+(String) temp1_user.get("Name")+"\n");
                    ta1.append ("UID                       : "+ (String) temp1_user.get("UID") + "\n");
                    ta1.append ("DEPARTMENT  : " + (String) temp1_user.get("Department") + "\n");
                    ta1.append ("BRANCH             : " + (String) temp1_user.get("Branch") + "\n");
                    ta1.append ("E-MAIL                : " + (String) temp1_user.get("Email-id")+ "\n");
                    ta1.append ("CELL.NO             : " + (Long) temp1_user.get("Mobile no")+ "\n");
                    ta1.append("FINE                     : "+(Long) temp1_user.get("Fine")+ "\n");
                    ta1.append("HOLDINGS          : "+(Long) temp1_user.get("holdings")+ "\n");
                    ta1.append("\n\n");
                }
            }

        }
        catch (Exception erp){
            System.out.println("error 1");
        }
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ft.setVisible(true);
                f10.setVisible(false);
            }
        });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });
    }
}
class Back_admin{
    Back_admin(Frame home,Frame back){
        Frame f10;
        Panel p1,p2;
        TextField t1,t2;
        Label l1,l2,l3;
        Button b1,b2,b3,b4;
        Checkbox c1;


        f10= new Frame("Entry to admin page");
        f10.setVisible(true);
        f10.setSize(1920,1080);

        p1= new Panel();
        p2= new Panel();
        c1=new Checkbox("show password");

        t1=new TextField(20);
        t2=new TextField(20);
        t2.setEchoChar('*');

        l1= new Label("Admin Username");
        l2=new Label("Admin Password");
        l3=new Label("*** ENTRY TO ADMIN PAGE ***");


        // b1=new Button("?Forgetpassword");
        //  b4=new Button("Sign up");
        b2=new Button("Back");
        b3=new Button("Next");

        Font f1 = new Font("Times New Roman", 1, 15);
        Font f2 = new Font("Times New Roman", 1, 25);

        l3.setFont(f2);
        l1.setFont(f1);
        l2.setFont(f1);
        //b4.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f1);

        f10.setLayout(null);
        p1.setLayout(null);
        p2.setBackground(Color.darkGray);

        p1.setBounds(550,200,450,450);
        p2.setBounds(549,199,452,452);

        l1.setBounds(615,350,130,20);
        t1.setBounds(750,350,170,20);
        l2.setBounds(615,400,130,20);
        t2.setBounds(750,400,170,20);
        c1.setBounds(750,430,170,20);
        b2.setBounds(650,550,70,30);
        b3.setBounds(850,550,70,30);
        l3.setBounds(590,260,365,30);

        f10.add(l1);
        f10.add(l2);
        f10.add(l3);
        f10.add(b2);
        f10.add(b3);
        f10.add(t1);
        f10.add(t2);
        f10.add(p1);
        f10.add(p2);
        c1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e)
            {
                // Handling Checkbox state change event
                if (c1.getState()) {
                    t2.setEchoChar((char)0);
                }
                else {
                    t2.setEchoChar('*');
                }
            }
        });
        //back
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                back.setVisible(true);
                f10.setVisible(false);
            }
        });
        JSONParser jsonParser = new JSONParser();
        String admin_username="";
        String admin_password="";
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/admin_login_details.json"));
            admin_username=(String) jsonObject.get("Id");
            admin_password=(String) jsonObject.get("Password");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String finalAdmin_username = admin_username;
        String finalAdmin_password = admin_password;
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (t1.getText().equals(finalAdmin_username) && t2.getText().equals(finalAdmin_password)) {
                        home.setVisible(true);
                        f10.setVisible(false);
                    }
                    else {
                        String msg="Entered username or password is \ninvalid";
                        message_popup mes= new message_popup(msg);
                    }
                }
                catch (Exception ep){
                    ep.printStackTrace();
                }
            }
        });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });
    }
}
class message_popup{
    message_popup(String msg){
        JFrame frame = new JFrame(" ");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JOptionPane messageBox = new JOptionPane("");
        messageBox.showMessageDialog(frame, msg);
    }
}
class User_signup{
    String name;
    String dept="";
    String branch="";
    String mobile_no;
    String user_mail_id;
    String padd;
    String tempadd;
    String addar;
    long temp;
    String per_user_id;
    String admin_mail;
    String admin_password;
    User_signup(Frame ft){
        TextField t1, t2, t3, t4, t5,t6,t7,t8;
        Label l1, l2, l3, l4, l5,l6,l7,l8;
        Button b1, b2;
        Frame f10=new Frame("User Creation");
        f10.setVisible(true);

        f10.setSize(1920, 1080);

        l1 = new Label("Name");
        l2 = new Label("Department");
        l3 = new Label("Branch");
        l4 = new Label("Mobile no.");
        l5 = new Label("Email-id");
        l6 = new Label("Temporary address");
        l7 = new Label("Permanent address");
        l8 = new Label("Aaddar no.");

        t1 = new TextField(20);
        t2 = new TextField(20);
        t3 = new TextField(20);
        t4 = new TextField(20);
        t5 = new TextField(20);
        t7 = new TextField(20);
        t8 = new TextField(20);
        t6 = new TextField(20);

        b1 = new Button("Submit");
        b2 = new Button("Back");

        Font f = new Font("Times New Roman", 1, 25);
        Font f1 = new Font("Times New Roman", 1, 15);

        b1.setFont(f);
        b2.setFont(f1);

        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        l6.setFont(f);
        l7.setFont(f);
        l8.setFont(f);

        f10.setLayout(null);

        l1.setBounds(515, 100, 240, 50);
        l2.setBounds(515, 170, 240, 50);
        l3.setBounds(515, 240, 240, 50);
        l4.setBounds(515, 310, 240, 50);
        l5.setBounds(515, 380, 240, 50);
        l6.setBounds(515, 450, 240, 50);
        l7.setBounds(515, 520, 240, 50);
        l8.setBounds(515, 590, 240, 50);


        t1.setBounds(785, 105, 290, 35);
        t2.setBounds(785, 175, 290, 35);
        t3.setBounds(785, 245, 290, 35);
        t4.setBounds(785, 315, 290, 35);
        t5.setBounds(785, 385, 290, 35);
        t6.setBounds(785, 455, 290, 35);
        t7.setBounds(785, 525, 290, 35);
        t8.setBounds(785, 595, 290, 35);

        b1.setBounds(715, 655, 110, 50);
        b2.setBounds(1195, 755, 110, 30);

        f10.add(l1);
        f10.add(l2);
        f10.add(l3);
        f10.add(l4);
        f10.add(l5);
        f10.add(l6);
        f10.add(l7);
        f10.add(l8);

        f10.add(b1);
        f10.add(b2);

        f10.add(t1);
        f10.add(t2);
        f10.add(t3);
        f10.add(t4);
        f10.add(t5);
        f10.add(t6);
        f10.add(t7);
        f10.add(t8);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = t1.getText();
                dept = t2.getText();
                branch = t3.getText();
                mobile_no = t4.getText();
                user_mail_id=t5.getText();
                tempadd=t6.getText();
                padd=t7.getText();
                addar=t8.getText();
                int check=0;
                String mobile_temp = "";

                if(name.length()==0 || tempadd.length()==0 || mobile_no.length()!=10 ||user_mail_id.length()==0 || addar.length()==0 || padd.length()==0 || tempadd.length()==0 ){
                    String msg="Entered invalid details";
                    message_popup mes= new message_popup(msg);
                }
                else if(mobile_no.length()==10 ){
                    try {
                        temp = Long.parseLong(mobile_no);
                        check=1;
                        mobile_temp=Long.toString(temp);
                    } catch (Exception klj) {
                        String msg="Entered invalid mobile number";
                        message_popup mes= new message_popup(msg);
                    }

                }
                if(  addar.length()!=12){
                    String msg="Entered invalid aaddar number";
                    message_popup mes= new message_popup(msg);
                }
                if(name.length()>0 && tempadd.length()>0  && mobile_temp.length()==10 && user_mail_id.length()>0 && addar.length()==12 && padd.length()>0 && tempadd.length()>0){

                    admin_login_details_db adb=new admin_login_details_db("Mail-id","MailPassword");
                     admin_mail=adb.return1();
                     admin_password=adb.return2();

                    Random random= new Random();
                   long otp = random.nextInt(1000000);

                    String message = "Thank you for Registering in Library.\nThe verification code for gmail is "+Long.toString(otp);

                    Mailsender mail=new Mailsender(user_mail_id,admin_mail,admin_password,message);
                    mail.start();
                    counter co=new counter();

                    try {
                        mail.join();
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }

                    int k =mail.check();
                    System.out.println(k+"k");

                    if(k==1){
                        String msg=" Either Network issue araised  \nOr Entered wrong Mail-id";
                        message_popup mes= new message_popup(msg);
                    }
                    if(k==3){
                        String msdd="OTP is send to your mail-id";
                        message_popup msd= new message_popup(msdd);

                        Frame f;
                        TextField t11;
                        Label l1;
                        Button b1;
                        f=new Frame("Otp verification");
                        f.setLocation(550,300);
                        f.setVisible(true);
                        f.setSize(450,150);
                        Font f1 = new Font("Times New Roman", 1, 15);
                        f.setLayout(null);
                        l1= new Label("Enter OTP");
                        t11=new TextField(10);
                        b1=new Button("ok");
                        l1.setFont(f1);
                        b1.setFont(f1);
                        l1.setBounds(90,70,90,20);
                        t11.setBounds(190,70,100,20);
                        b1.setBounds(330,70,30,25);
                        f.add(l1);
                        f.add(t11);
                        f.add(b1);
                        f.addWindowListener(new WindowAdapter() {
                            public void windowClosing(WindowEvent we) {
                                f.dispose();
                            }
                        });
                        b1.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                String temp96;
                                temp96 = t11.getText();
                                String temp2 = Long.toString(otp);
                                System.out.println(temp + "otp");
                                System.out.println(temp2 + "otp");
                                if (temp96.equals(temp2)) {
                                    f.setVisible(false);
                                    //conform=1;
                                    double temper = 0;
                                    String temp_code;
                                    String temp_String_store = "";
                                    String temparary;

                                    for (int i = 0; i < addar.length(); i++) {
                                        temper += (double) addar.charAt(i);
                                    }

                                    temp_String_store = name.substring(0, 3);

                                    for (int i = 0; i < user_mail_id.length(); i++) {
                                        temper += (double) user_mail_id.charAt(i);

                                    }
                                    temp_code = Double.toString(temper);
                                    temp_code = temp_code.substring(0, 5);
                                    // temparary=Book_name.substring(0,1);
                                    temp_String_store = temp_String_store.concat(temp_code);
                                    temp_String_store = temp_String_store.concat("@lib");
                                    per_user_id=temp_String_store;


                                    JSONParser jsonParser = new JSONParser();
                                    String uid = "";

                                    int j = 1;
                                    try {
                                        JSONArray userarray = (JSONArray) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/userdata.json"));
                                        for (int i = 0; i < userarray.toArray().length; i++) {
                                            JSONObject temp_user = (JSONObject) userarray.get(i);
                                            uid = (String) temp_user.get("UID");
                                            if (temp_String_store.equals(uid)) {
                                                j = 0;
                                            }
                                        }
                                        if (j == 0) {

                                            String msg = ("Entered details already exist");
                                            message_popup mes = new message_popup(msg);
                                        }

                                    } catch (Exception erp) {

                                    }

                                    if (j == 1) {
                                        String msg="    User Id is generated  \n      Uid:" + temp_String_store;
                                        message_popup msdrp= new message_popup(msg);
                                        user_idpass_get idp=new user_idpass_get(per_user_id,user_mail_id,admin_mail,admin_password);
                                        try {

                                            Userdatabase jdb = new Userdatabase(name, dept, branch, user_mail_id, temp, padd, tempadd, addar, temp_String_store);
                                            t1.setText("");
                                            t2.setText("");
                                            t3.setText("");
                                            t4.setText("");
                                            t5.setText("");
                                            t6.setText("");
                                            t7.setText("");
                                            t8.setText("");
                                        } catch (Exception database_exception) {
                                        }
                                    }
                                }
                                else {
                                    String msddl = "Entered wrong OTP";
                                    message_popup msdk = new message_popup(msddl);
                                }
                                 f.setVisible(false);
                            }
                        });
                }
                }
            }
        });

        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ft.setVisible(true);
                f10.setVisible(false);
            }
              });
        f10.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f10.dispose();
            }
        });
    }
}
class counter{
    counter(){
        Frame f20;
        Label l20;
        f20=new Frame("        Wait for response");
        f20.setLocation(650,300);
        f20.setVisible(true);
        f20.setSize(350,150);
        f20.setLayout(null);
        Font f1 = new Font("Times New Roman", 1, 15);
        l20 =new Label("Wait for (10)s");
        l20.setFont(f1);
        l20.setBounds(120,70,1200,20);
        f20.add(l20);
        for(int i=9;i>-1;i--) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            l20.setText("Wait for("+i+")s");
        }
        f20.dispose();
    }
}
class user_idpass_get{
    user_idpass_get(String uid,String user_mail_id,String admin_mail,String admin_password){
        Frame f;
        TextField t11,t2,t3;
        Label l1,l2,l3,l4;
        Button b1;

        f=new Frame("User Password set");
        f.setLocation(550,300);
        f.setVisible(true);
        f.setSize(450,300);

        Font f1 = new Font("Times New Roman", 1, 15);
        Font f45 = new Font("Times New Roman", 1, 25);
        f.setLayout(null);

        l1= new Label("UID                               :");
        t11=new TextField(18);
        t11.setText(uid);
        l2= new Label("Create Password     :");
        l4= new Label("USER PASSWORD CREATION");
        t2=new TextField(18);
        l3= new Label("Re-Enter Password :");
        t3=new TextField(2018);
        b1=new Button("OK");
        l1.setFont(f1);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f45);
        b1.setFont(f1);

        l4.setBounds(40,70,380,40);
        l1.setBounds(70,140,180,20);
        l2.setBounds(70,180,180,20);
        l3.setBounds(70,220,180,20);
        t11.setBounds(270,140,135,20);
        t2.setBounds(270,180,135,20);
        t3.setBounds(270,220,135,20);
        b1.setBounds(210,260,40,25);

        f.add(l1);
        f.add(t11);
        f.add(b1);
        f.add(t2);
        f.add(t3);
        f.add(l2);
        f.add(l3);
        f.add(l4);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(t2.getText().equals(t3.getText())){
                    user_login_database ud= new user_login_database(uid,t2.getText());
                    String message = "Thank you for Registering in Library.\n Don't share you user-id and password with other\nUID :"+uid+"\nPassword : "+t2.getText();

                    Mailsender mail=new Mailsender(user_mail_id,admin_mail,admin_password,message);
                    mail.start();
                    f.setVisible(false);
                }
                else{
                    String msg="    Password Mis-matched";
                    message_popup msf=new message_popup(msg);
                }
            }
        });
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f.dispose();
            }
        });
    }
}
class user_login_database{
    user_login_database(String uid, String pass){
        JSONObject jsonObject = new JSONObject();
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArrayUser = new JSONArray();

        try (FileReader reader = new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/User_login_details.json")) {
            Object obj = jsonParser.parse(reader);
            if (obj instanceof JSONArray) {
                jsonArrayUser = (JSONArray) obj;
            } else if (obj instanceof JSONObject) {
                // If the parsed object is a JSONObject, add it to the JSONArray
                jsonArrayUser.add(obj);
            }
        } catch (Exception e) {

        }

        jsonObject.put("Id",uid);
        jsonObject.put("Password", pass);

        jsonArrayUser.add(jsonObject);

        try {
            FileWriter file = new FileWriter("C:/Users/heman/OneDrive/Desktop/CIA2project/json/User_login_details.json");
            file.write(jsonArrayUser.toJSONString());
            file.close();
        } catch (IOException e) {
        }
    }
}
class admin_login_details_db{
    String ids="";
    String pass="";
    admin_login_details_db(String id,String password){
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/admin_login_details.json"));
            ids=(String) jsonObject.get("Mail-id");
            pass=(String) jsonObject.get("MailPassword");
        }
        catch (Exception et){
            et.printStackTrace();
            System.out.println("adminlogin");
        }
    }
    String return1(){
        return ids;
    }
    String return2(){
        return pass;
    }
}
class otp_verify {
    int conform=0;

    otp_verify(long otp){
        Frame f;
        TextField t1;
        Label l1;
        Button b1;
        f=new Frame("Otp verification");
        f.setLocation(550,300);
        f.setVisible(true);
        f.setSize(450,150);
        Font f1 = new Font("Times New Roman", 1, 15);

        f.setLayout(null);
        l1= new Label("Enter OTP");
        t1=new TextField(10);
        b1=new Button("ok");
        l1.setFont(f1);
        b1.setFont(f1);
        l1.setBounds(90,70,90,20);
        t1.setBounds(190,70,100,20);
        b1.setBounds(330,70,30,25);
        f.add(l1);
        f.add(t1);
        f.add(b1);
        System.out.println(conform);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f.dispose();
            }
        });
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String temp;
                temp= t1.getText();
                String temp2=Long.toString(otp);
                System.out.println(temp+"otp");
                System.out.println(temp2+"otp");
                if(temp.equals(temp2)){
                    conform=1;
                }
                else {
                    conform=2;
                }
                f.setVisible(false);

            }
        });
    }
    int sent(){
        System.out.println(conform+"conform");
        return conform;
    }
}
class Userdatabase{
    Userdatabase(String name,String dept,String branch,String mail,Long mobile_no,String pad,String tead,String addar,String uid){

        JSONObject jsonObject = new JSONObject();
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArrayUser = new JSONArray();

        try (FileReader reader = new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/userdata.json")) {
            Object obj = jsonParser.parse(reader);
            if (obj instanceof JSONArray) {
                jsonArrayUser = (JSONArray) obj;
            } else if (obj instanceof JSONObject) {
                // If the parsed object is a JSONObject, add it to the JSONArray
                jsonArrayUser.add(obj);
            }
        } catch (Exception e) {

        }

        jsonObject.put("UID",uid);
        jsonObject.put("Name",name);
        jsonObject.put("Department", dept);
        jsonObject.put("Branch", branch);
        jsonObject.put("Email-id", mail);
        jsonObject.put("Mobile no", mobile_no);
        jsonObject.put("Addar no", addar);
        jsonObject.put("Temparary address", tead);
        jsonObject.put("Permanent address", pad);
        jsonObject.put("Fine", 0);
        jsonObject.put("holdings", 0);

        jsonArrayUser.add(jsonObject);

        try {
            FileWriter file = new FileWriter("C:/Users/heman/OneDrive/Desktop/CIA2project/json/userdata.json");
            file.write(jsonArrayUser.toJSONString());
            file.close();
        } catch (IOException e) {

        }
    }
}

class jsondatabase{
    jsondatabase(String book_name, String Author,String Publisher,String book_category,Integer initial_copies,String book_code){
        JSONObject jsonObject = new JSONObject();
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArrayUser = new JSONArray();

        try (FileReader reader = new FileReader("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json")) {
            Object obj = jsonParser.parse(reader);
            if (obj instanceof JSONArray) {
                jsonArrayUser = (JSONArray) obj;
            } else if (obj instanceof JSONObject) {
                // If the parsed object is a JSONObject, add it to the JSONArray
                jsonArrayUser.add(obj);
            }
        } catch (Exception e) {

        }

        jsonObject.put("Book-id",book_code);
        jsonObject.put("Book Title", book_name);
        jsonObject.put("Author", Author);
        jsonObject.put("Publisher", Publisher);
        jsonObject.put("Book category",book_category);
        jsonObject.put("Initial copies",initial_copies);
        jsonObject.put("Present copies",initial_copies);
        jsonObject.put("Borrowed copies",0);

        jsonArrayUser.add(jsonObject);

        try {
            FileWriter file = new FileWriter("C:/Users/heman/OneDrive/Desktop/CIA2project/json/books_details.json");
            file.write(jsonArrayUser.toJSONString());
            file.close();
        } catch (IOException e) {

        }
    }
}
class Mailsender extends Thread{
String admin_password;
String user_mail_id;
String admin_mail_id;
String message;
    int k=0;

   public void run(){

       String to=user_mail_id;
       String Subject="Mail from Library";
       String from=admin_mail_id;
       send_mail(message,Subject,to,from);
   }
    Mailsender(String user_id,String admin_id,String admin_pass,String msg){
       message=msg;
       admin_mail_id=admin_id;
       user_mail_id=user_id;
       admin_password=admin_pass;
    }
    int check(){
        return k;
    }
    private void send_mail(String message, String subject, String to, String from)  {
        String host="smtp.gmail.com";
        Properties prop= System.getProperties();
        prop.put("mail.smtp.host",host);
        prop.put("mail.smtp.port","465");
        prop.put("mail.smtp.ssl.enable","true");
        prop.put("mail.smtp.auth","true");

        Session ses=Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,admin_password);
            }
        });
        ses.setDebug(true);


        MimeMessage m= new MimeMessage(ses);
        try{
            m.setFrom(from);
            m.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(to)));
            m.setSubject(subject);
            m.setText(message);
            try{Transport.send(m);}
            catch (Exception e3){
                e3.printStackTrace();
               k=1;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(k!=1){
            k=3;
        }
    }
}
class Main {
    public static void main(String ar[]) {
        Myframe f = new Myframe();
    }
}
