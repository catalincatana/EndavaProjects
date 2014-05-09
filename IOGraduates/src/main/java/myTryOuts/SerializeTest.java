package myTryOuts;

import java.io.IOException;

/**
 * Created by ccatana on 5/9/2014.
 */
public class SerializeTest {
    public static void main(String[] args) {
        String fileName="employee.ser";
        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("Pankaj");
        emp.setSalary(5000);

        //serialize to file
        try {
            Serialization.serialize(emp, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Employee empNew = null;
        try {
            empNew = (Employee) Serialization.deserialize(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("emp Object::"+emp);
        System.out.println("empNew Object::"+empNew);
    }

}
