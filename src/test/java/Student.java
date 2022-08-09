import java.util.*;
import java.sql.*;
public class Student{
    public static void main(String [] args){
        Connection connection=null;
        try{
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","Guru@1508");
            System.out.println("connected succesfully");
        }
        catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        int age,i=1;
        String name;
        Scanner inp=new Scanner(System.in);
        while(i==1)
        {
        System.out.println("ENTER 1 TO INSERT , 2 TO DISPLAY, 3 TO DELETE,5 TO SQL INJECTION ");
        int choice=inp.nextInt();
            if(choice==1)
            {
                System.out.println("enter the name");
                name=inp.next();
                System.out.println("enter the age");
                age=inp.nextInt();
                try{
                    String Q1="insert into employee (name,age) values (?,?)";
                    PreparedStatement ps=connection.prepareStatement(Q1);
                    ps.setString(1,name);
                    ps.setInt(2,age);
                    ps.executeUpdate();
                    System.out.println("data inserted ");
                }
                catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }

            }
            if(choice==2)
            {

                try{
                    int id;
                    String Q="select * from employee";
                    PreparedStatement ps=connection.prepareStatement(Q);
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                        id=rs.getInt(1);
                        name=rs.getString(2);
                        age=rs.getInt(3);
                        System.out.println(id +" "+ name +" "+ age);
                    }
                    }

                catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }

            }


            if(choice==3)
            {
                try {
                    System.out.println("Enter the id ");
                    int id=inp.nextInt();
                    String Q = "delete from employee where id='"+id+"'";
                    Statement ps = connection.createStatement();
                    ps.executeUpdate(Q);
                }

                catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }

            }


            if(choice==4)
            {

                try{
                    int id;
                    name=inp.next();
                    String Q="select * from employee where name=?";
                    PreparedStatement ps=connection.prepareStatement(Q);
                    ps.setString(1,name);
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                        id=rs.getInt(1);
                        name=rs.getString(2);
                        age=rs.getInt(3);
                        System.out.println(id +" "+ name +" "+ age);
                    }
                }

                catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }

            }

            if(choice==5)
            {

                try{
                    int id;
                    name=inp.next();
                    String Q="select * from employee where name = '"+name+"'";
                    Statement ps=connection.createStatement();
                    ResultSet rs=ps.executeQuery(Q);
                    while(rs.next()){
                        id=rs.getInt(1);
                        name=rs.getString(2);
                        age=rs.getInt(3);
                        System.out.println(id +" "+ name +" "+ age);
                    }
                }

                catch (SQLException throwables)
                {
                    throwables.printStackTrace();
                }

            }

            System.out.println("enter 1 to continue");
            i=inp.nextInt();

        }

    }
}