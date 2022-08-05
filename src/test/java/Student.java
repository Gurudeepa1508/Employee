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
        int id,i=1;
        String name;
        Scanner inp=new Scanner(System.in);
        while(i==1)
        {
        System.out.println("ENTER 1 TO INSERT , 2 TO DISPLAY");
        int choice=inp.nextInt();
            if(choice==1)
            {
                System.out.println("enter the id");
                id=inp.nextInt();
                System.out.println("enter the name ");
                name=inp.next();
                try{
                    String Q1="insert into sample (id,name) values (?,?)";
                    PreparedStatement ps=connection.prepareStatement(Q1);
                    ps.setInt(1,id);
                    ps.setString(2,name);
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
                    String Q="select * from sample ";
                    PreparedStatement ps=connection.prepareStatement(Q);
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                        id=rs.getInt(1);
                        name=rs.getString(2);
                        System.out.println(id +" "+ name);
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