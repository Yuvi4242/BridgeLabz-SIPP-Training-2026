import java.io.*;
import java.util.*;

public class EmployeeSkillAssignment {
    static class Employee implements Serializable {
        private static final long serialVersionUID = 1L;
        int id; String name; String department; double salary; int[] skills;
        public Employee(int id,String name,String dept,double sal,int[] skills){this.id=id;this.name=name;this.department=dept;this.salary=sal;this.skills=skills;}
        public String toString(){return "Employee[id="+id+",name="+name+",dept="+department+",salary="+salary+",skills="+Arrays.toString(skills)+"]";}
    }

    // find subsets of skill scores that sum to target
    static void findTeams(int[] arr,int target){
        List<Integer> cur=new ArrayList<>();
        backtrack(arr,0,target,cur);
    }
    static void backtrack(int[] arr,int idx,int rem,List<Integer> cur){
        if(rem==0){ System.out.println("Team indices: " + cur); return; }
        if(rem<0||idx==arr.length) return;
        // include
        cur.add(idx);
        backtrack(arr,idx+1,rem-arr[idx],cur);
        cur.remove(cur.size()-1);
        // exclude
        backtrack(arr,idx+1,rem,cur);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            System.out.print("Enter skill scores (comma separated): ");
            String[] parts=sc.nextLine().split("[,\\s]+");
            int[] arr=new int[parts.length];
            for(int i=0;i<parts.length;i++) arr[i]=Integer.parseInt(parts[i]);
            System.out.print("Enter target sum: ");
            int target=Integer.parseInt(sc.nextLine().trim());
            System.out.println("Possible teams:");
            findTeams(arr,target);

            // read an employee and serialize
            System.out.print("Enter employee id: "); int id=Integer.parseInt(sc.nextLine().trim());
            System.out.print("Enter name: "); String name=sc.nextLine();
            System.out.print("Enter department: "); String dept=sc.nextLine();
            System.out.print("Enter salary: "); double sal=Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter skill scores for this employee (comma separated): ");
            String[] s2=sc.nextLine().split("[,\\s]+"); int[] skills=new int[s2.length]; for(int i=0;i<s2.length;i++) skills[i]=Integer.parseInt(s2[i]);
            Employee e=new Employee(id,name,dept,sal,skills);
            try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("employee.ser"))){ oos.writeObject(e); }
            try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("employee.ser"))){ Employee r=(Employee)ois.readObject(); System.out.println("Recovered: "+r); }
        }catch(Exception ex){ System.out.println("Error: " + ex.getMessage()); }
        finally{ sc.close(); }
    }
}

