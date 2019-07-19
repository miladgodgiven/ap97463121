package godgiven_school;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class main {

    public static ArrayList<student> studentList = new ArrayList<student>();
    public static ArrayList<teacher> teacherList = new ArrayList<teacher>();
    public static ArrayList<lesson> lessonList = new ArrayList<lesson>();

    public static void main(String[] args) throws FileNotFoundException {

        setStudentList();
        setTeacherList();
        setLessonList();

        main();

        lessonsaver();
        teachersaver();
        studentsaver();


    }


    public static void main(){
        int choose;

        Scanner input = new Scanner(System.in);

        System.out.println("\n\n^^^^^^^^^^^^^^^^\n>> WELCOME TO GODGIVEN SCHOOL <<");
        System.out.println(" FOR LOG IN AS A ... \nMANAGER => PRESS '1'\nTEACHER => PRESS '2'\n" +
                "STUDENT => PRESS '3'");
        choose = input.nextInt();


        if (choose == 1) {
            userpass("manager");
        }
        if (choose == 2) {
            userpass("teachers");
        }
        if (choose == 3) {
            userpass("students");
        }


    }

    public static void userpass(String person)  {
        String user, id,ch;
        Scanner input = new Scanner(System.in);

        System.out.print("ENTER YOUR USERNAME :");
        user = input.nextLine();
        System.out.print("ENTER YOUR ID :");
        id = input.nextLine();


        System.out.println("*******************");
        if (person.equals("manager")) {
            if (user.equals("milad") && id.equals("2000")) {
                manager_s0();
            }else {
                System.out.println("!! WRONG USERNSME OR ID !!");
                System.out.println("\nPRESS R TO RETRY");
                ch=input.nextLine();
                if (ch.equals("r")){
                    main();
                }
            }
        }
        if (person.equals("teachers")) {
            if (userpass_scanner_teacher(user, id)) {
                teacher_s0(user);
            }else {
                System.out.println("!! WRONG USERNAME OR ID !!");
                System.out.println("\nPRESS R TO RETRY");
                ch=input.nextLine();
                if (ch.equals("r")){
                    main();
                }
            }
        }
        if (person.equals("students")) {
            if (userpass_scanner_student(user, id)) {
                student_s0(user, id);
            }else {
                System.out.println("!! WRONG USERNAME OR ID !!");
                System.out.println("\nPRESS R TO RETRY");
                ch=input.nextLine();
                if (ch.equals("r")){
                    main();
                }
            }
        }

    }

    //====================================MANAGER======================================
    public static void manager_s0()  {

        int choos;
        Scanner input = new Scanner(System.in);

        System.out.println("WHAT YOU WANT TODO?");
        System.out.println("ADD A LESSON => '1' ");
        System.out.println("ADD A TEACHER => '2' ");
        System.out.println("ADD A STUDENT => '3' ");
        System.out.println("SEE ALL LESSONS => '4' ");
        System.out.println("SEE A LESSON DETAILS => '5'");
        System.out.print("PRESS A NUMBER : ");
        choos = input.nextInt();

        if (choos == 1) {
            manager_ch1();
            System.out.println("=================\nPRESS B TO BACK\nPRESS Q TO QUIT");
            if (input.next().equals("b")) {
                manager_s0();
            }
        }
        if (choos == 2) {
            manager_ch2();
            System.out.println("=================\nPRESS B TO BACK\nPRESS Q TO QUIT");
            if (input.next().equals("b")) {
                manager_s0();
            }
        }
        if (choos == 3) {
            manager_ch3();
            System.out.println("=================\nPRESS B TO BACK\nPRESS Q TO QUIT");
            if (input.next().equals("b")) {
                manager_s0();
            }
        }
        if (choos == 4) {
            manager_ch4();
            System.out.println("=================\nPRESS B TO BACK\nPRESS Q TO QUIT");
            if (input.next().equals("b")) {
                manager_s0();
            }
        }
        if (choos == 5) {
            manager_ch5();
            System.out.println("=================\nPRESS B TO BACK\nPRESS Q TO QUIT");
            if (input.next().equals("b")) {
                manager_s0();
            }
        }
    }

    public static void manager_ch1()  {
        Scanner in = new Scanner(System.in);

        lesson lesson = new lesson();

        System.out.print("ENTER LESSON NAME :");
        lesson.setName(in.nextLine());
        System.out.print("ENTER LESSON ID :");
        lesson.setId(in.nextLine());
        System.out.print("ENTER TEACHER FOR LESSON (of These teachers)=>");
        teachers_list();
        System.out.println();
        lesson.setTeacher(in.nextLine());

        lessonList.add(lesson);

        for (teacher t : teacherList){
            if(t.getFullname().equals(lesson.getTeacher())){
                t.lessons.add(lesson);
                t.setLesson_num(t.getLesson_num()+1);
            }
        }
    }

    public static void manager_ch2()  {
        Scanner in = new Scanner(System.in);

        teacher teacher = new teacher();
        System.out.print("ENTER TEACHER NAME :");
        teacher.setFullname(in.nextLine());
        System.out.print("ENTER TEACHER ID :");
        teacher.setId(in.nextLine());

        teacherList.add(teacher);
    }

    public static void manager_ch3() {
        Scanner in = new Scanner(System.in);

        student student = new student();
        System.out.print("ENTER STUDENT NAME :");
        student.setFullname(in.nextLine());
        System.out.print("ENTER STUDENT ID :");
        student.setId(in.nextLine());
        System.out.print("ENTER STUDENT FIELD :");
        student.setReshte(in.nextLine());

        studentList.add(student);
    }

    public static void manager_ch4() {
        System.out.println("**********");
        for (lesson l : lessonList) {
            System.out.print(l.getName() + "\n");
        }
        System.out.println("**********");
    }

    public static void manager_ch5()  {
        Scanner in = new Scanner(System.in);

        String lesson;

        System.out.println("WHICH LESSON DATA YOU WANT TO SEE?(available lessons )=>");
        manager_ch4();
        lesson = in.nextLine();

        for (lesson l : lessonList) {
            if (l.getName().equals(lesson)) {
                lesson_tata(l);
            }
        }
    }



    //====================================TEACHER======================================
    public static void teacher_s0(String teachername) {
        int choos;
        Scanner input = new Scanner(System.in);

        System.out.println("WHAT YOU WANT TODO?");
        System.out.println("SEE YOUR CLASSES AND STUDENTS => '1' ");
        System.out.println("REMOVE A STUDENT => '2' ");
        System.out.println("ENTER STUDENTS SCORES => '3' ");
        System.out.print("PRESS A NUMBER : ");
        choos = input.nextInt();

        if (choos == 1) {
            teacher_ch1(teachername);
            System.out.println("=================\nPRESS B TO BACK\nPRESS Q TO QUIT");
            if (input.next().equals("b")) {
                teacher_s0(teachername);
            }
        }
        if (choos == 2) {
            teacher_ch2(teachername);
            System.out.println("=================\nPRESS B TO BACK\nPRESS Q TO QUIT");
            if (input.next().equals("b")) {
                teacher_s0(teachername);
            }
        }
        if (choos == 3) {
            teacher_ch3(teachername);
            System.out.println("=================\nPRESS B TO BACK\nPRESS Q TO QUIT");
            if (input.next().equals("b")) {
                teacher_s0(teachername);
            }
        }
    }

    public static void teacher_ch1(String teachername) {

        for (teacher t : teacherList) {
            if (t.getFullname().equals(teachername)) {
                for (int i = 0; i < t.getLesson_num(); i++) {
                    lesson_tata(t.lessons.get(i));
                }
            }
        }
    }

    public static void teacher_ch2(String teachername){

        String name, id, classe, classid, teacher;
        Scanner input = new Scanner(System.in);

        System.out.print("ENTER STUDENT NAME :");
        name = input.nextLine();
        System.out.print("ENTER STUDENT ID :");
        id = input.next();
        System.out.print("ENTER STUDENT CLASS :");
        classe = input.next();

        for (lesson l : lessonList) {
            if (l.getName().equals(classe)) {
                Iterator<student> iter = l.getStudents().iterator();
                while (iter.hasNext()) {
                    student st = iter.next();
                    if (st.getFullname().equals(name) && st.getId().equals(id)) {
                        iter.remove();
                        l.setStudent_num(l.getStudent_num()-1);
                    }
                }
            }
        }
        for(student s : studentList){
            if (s.getFullname().equals(name)&&s.getId().equals(id)){
                Iterator<lesson> iter = s.lessons.iterator();
                while (iter.hasNext()){
                    lesson l = iter.next();
                    if (l.getName().equals(classe)){
                        iter.remove();
                    }
                }
            }
        }
        for (teacher t : teacherList) {
            if (t.getFullname().equals(teachername)) {
                for (lesson l : t.getLessons()) {
                    if (l.getName().equals(classe)) {
                        Iterator<student> iter = l.getStudents().iterator();
                        while (iter.hasNext()) {
                            student s = iter.next();
                            if (s.getFullname().equals(name) && s.getId().equals(id)) {
                                iter.remove();
                                l.setStudent_num(l.getStudent_num() - 1);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void teacher_ch3(String teachername) {
        System.out.println("***************");
        String name, id, classe, classid, teacher, nomre;
        Scanner input = new Scanner(System.in);

        System.out.print("ENTER STUDENT NAME :");
        name = input.nextLine();
        System.out.print("ENTER STUDENT ID :");
        id = input.next();
        System.out.print("ENTER STUDENT CLASS :");
        classe = input.next();
        System.out.print("ENTER STUDENT SCORE :");
        nomre = input.next();

        for (lesson l : lessonList) {
            if (l.getName().equals(classe)) {
                for (student s : l.getStudents()) {
                    if (s.getFullname().equals(name) && s.getId().equals(id)) {
                        s.setNomre(nomre);
                    }
                }
            }
        }
        for (student s : studentList){
            if (s.getFullname().equals(name)&&s.getId().equals(id)){
                for (lesson l : s.getLessons()){
                    if (l.getName().equals(classe)){
                        l.setNomre(nomre);
                    }
                }
            }
        }
        for (teacher t : teacherList) {
            if (t.getFullname().equals(teachername)) {
                for (lesson l : t.getLessons()) {
                    if (l.getName().equals(classe)) {
                        for (student s : l.getStudents()) {
                            if (s.getFullname().equals(name) && s.getId().equals(id)) {
                                s.setNomre(nomre);
                            }
                        }
                    }
                }
            }
        }

    }



    //====================================STUDENT======================================
    public static void student_s0(String studentname, String id) {
        int choos;
        Scanner input = new Scanner(System.in);

        System.out.println("WHAT YOU WANT TODO?");
        System.out.println("SEE ALL CLASSES => '1' ");
        System.out.println("ADD TO A CLASS => '2' ");
        System.out.println("REMOVE A CLASS => '3' ");
        System.out.println("SEE YOUR CLASSES => '4' ");
        System.out.print("PRESS A NUMBER : ");
        choos = input.nextInt();

        if (choos == 1) {
            student_ch1();
            System.out.println("=================\nPRESS B TO BACK\nPRESS Q TO QUIT");
            if (input.next().equals("b")) {
                student_s0(studentname, id);
            }
        }
        if (choos == 2) {
            student_ch2(studentname, id);
            System.out.println("=================\nPRESS B TO BACK\nPRESS Q TO QUIT");
            if (input.next().equals("b")) {
                student_s0(studentname, id);
            }
        }
        if (choos == 3) {
            student_ch3(studentname,id);
            System.out.println("=================\nPRESS B TO BACK\nPRESS Q TO QUIT");
            if (input.next().equals("b")) {
                student_s0(studentname, id);
            }
        }
        if (choos == 4) {
            student_ch4(studentname);
            System.out.println("=================\nPRESS B TO BACK\nPRESS Q TO QUIT");
            if (input.next().equals("b")) {
                student_s0(studentname, id);
            }
        }
    }

    public static void student_ch1() {
        System.out.println("******************");

        for (lesson l : lessonList) {
            lsson_tata_forstudent(l);
        }

    }

    public static void student_ch2(String name, String id) {
        System.out.println("******************");
        String lessonname;
        boolean lessonexsist = false;
        Scanner input = new Scanner(System.in);

        System.out.print("ENTER LESSON NAME :");
        lessonname = input.next();

        for (lesson l : lessonList) {
            if (l.getName().equals(lessonname)) {
                l.students.add(new student(name, id));
                l.setStudent_num(l.getStudent_num()+1);
            }
        }

        for (student s : studentList){
            if(s.getFullname().equals(name)&& s.getId().equals(id)){
                for (lesson l : lessonList){
                    if (l.getName().equals(lessonname)){
                        s.lessons.add(l);
                    }
                }
            }
        }
//        for (lesson l : lessonList) {
//            if (l.getName().equals(lessonname)) {
//                for (teacher t : teacherList) {
//                    if (t.getFullname().equals(l.getTeacher())){
//                        for (lesson l2 : t.getLessons()) {
//                            if (l2.getName().equals(lessonname)) {
//                                l.students.add(new student(name, id));
//                                l.setStudent_num(l.getStudent_num()+1);
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }

    public static void student_ch3(String studentname,String id){
        System.out.println("******************");
        String lessonname;
        Scanner input=new Scanner(System.in);

        System.out.print("ENTER LESSON NAME :");
        lessonname=input.next();

        for (student s : studentList){
            if (s.getFullname().equals(studentname)&&s.getId().equals(id)){
                Iterator<lesson> iter = s.lessons.iterator();
                while (iter.hasNext()){
                    lesson l = iter.next();
                    if (l.getName().equals(lessonname)){
                        iter.remove();
                    }
                }
            }
        }
        for (lesson l : lessonList){
            if(l.getName().equals(lessonname)){
                Iterator<student> it = l.getStudents().iterator();
                while (it.hasNext()){
                    student s = it.next();
                    if(s.getFullname().equals(studentname)&&s.getId().equals(id)){
                        it.remove();
                        l.setStudent_num(l.getStudent_num()-1);
                    }
                }
            }
        }
    }

    public static void student_ch4(String studentname){
        System.out.println("******************");

        System.out.println("    lesson________score");
        for (student s : studentList){
            if(s.getFullname().equals(studentname)){
                for (lesson l : s.getLessons()){
                    System.out.printf("%10s",l.getName());
                    System.out.print("        ");
                    System.out.print(l.getNomre());
                    System.out.println();
                }
            }
        }
    }



//================================TOOLS==========================================
    public static void teachers_list() {

        System.out.print("( ");
        for (teacher t :teacherList){
            System.out.print(t.getFullname()+"  ");
        }
        System.out.print(" )");
    }

    public static void file_creator(String name){

        File f1 = new File(name+".txt");
        try {
            f1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void file_writer(String filename,String text,boolean append){
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filename+".txt",append);
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean userpass_scanner_teacher(String user, String id ){
        String ch;Scanner input = new Scanner(System.in);
        boolean answer=false;

        for (teacher te : teacherList){
            if(te.getFullname().equals(user) && te.getId().equals(id)) {
            answer=true;
            }
        }
        return answer;
    }

    public static boolean userpass_scanner_student(String user,String id ){
        String ch;Scanner input = new Scanner(System.in);
        boolean answer=false;

        for (student st : studentList){
            if(st.getFullname().equals(user) && st.getId().equals(id)) {
                answer=true;
            }
        }
        return answer;
    }

    public static void lesson_tata(lesson lesson){

        System.out.println("****************");
        System.out.println("LESSON NAME =>"+lesson.getName());
        System.out.println("LESSON ID =>"+lesson.getId());
        System.out.println("LESSON TEACHER => "+lesson.getTeacher());
        System.out.println("STUDENT NAMES____________ID_____SCORES: ");

        int snum;
        for (snum=0;snum<lesson.getStudent_num();snum++){
            student s = lesson.students.get(snum);
            System.out.printf("%13s",s.getFullname());
            System.out.print("      ");
            System.out.printf("%8s",s.getId());
            System.out.print("      ");
            System.out.printf("%2s",s.getNomre());

            System.out.println();
        }
        System.out.println("LESSON STUDENTS NUMBER => "+snum);
        System.out.println("***************");

    }

    public static void lsson_tata_forstudent(lesson lesson) {

        System.out.println("***************");
        System.out.println("LESSON NAME => " + lesson.getName());
        System.out.println("LESSON ID => " + lesson.getId());
        System.out.println("LESSON TEACHER => " + lesson.getTeacher());

        System.out.println("LESSON STUDENTS NUMBER => "+lesson.getStudent_num());
        System.out.println("***************");

    }



    public static void setStudentList ()throws FileNotFoundException{
        student[] student = new student[100];

        for (int i=0;i<student.length;i++){
            student[i] = new student();
        }

        File students = new File("students.txt");
        Scanner sc = new Scanner(students);
        sc.useDelimiter("/");
        int snum;
        for (snum=0;sc.hasNext();snum++){
            File student_data = new File("students\\student_"+sc.next()+".txt");
            Scanner sc2 = new Scanner(student_data);
            sc2.useDelimiter("/");

            student[snum].setFullname(sc2.next());
            student[snum].setId(sc2.next());
            student[snum].setReshte(sc2.next());

            for (int i=0;sc2.hasNext();i++){
                student[snum].lessons.add(i, new lesson());
                student[snum].lessons.get(i).setName(sc2.next());
                student[snum].lessons.get(i).setNomre(sc2.next());
            }
        }

        for (int i=0;i<snum;i++){
            studentList.add(student[i]);
        }
    }

    public static void setTeacherList ()throws FileNotFoundException{
        teacher[] teacher = new teacher[50];

        for (int i=0;i<teacher.length;i++){
            teacher[i] = new teacher();
        }

        File teachers = new File("teachers.txt");
        Scanner sc = new Scanner(teachers);
        sc.useDelimiter("/");
        int tnum;
        for (tnum=0;sc.hasNext();tnum++){
            File teacher_data = new File("teachers\\teacher_"+sc.next()+".txt");
            Scanner sc2 = new Scanner(teacher_data);
            sc2.useDelimiter("/");

            teacher[tnum].setFullname(sc2.next());
            teacher[tnum].setId(sc2.next());
            teacher[tnum].setLesson_num(sc2.nextInt());

            for (int i=0;sc2.hasNext();i++){
                teacher[tnum].lessons.add(i, new lesson(sc2.next(),sc2.next()));

                File lesson_data = new File("lessons\\lesson_"+teacher[tnum].lessons.get(i).getName()+".txt");
                Scanner sc3 = new Scanner(lesson_data);
                sc3.useDelimiter("/");

                String jump = sc3.next();
                teacher[tnum].lessons.get(i).setTeacher(sc3.next());
                teacher[tnum].lessons.get(i).setStudent_num(sc3.nextInt());

                for (int j=0;sc3.hasNext();j++){
                    teacher[tnum].lessons.get(i).students.add(new student(sc3.next(),sc3.next(),sc3.next()));
                }
            }
        }

        for (int i=0;i<tnum;i++){
            teacherList.add(teacher[i]);
        }
    }

    public static void setLessonList ()throws FileNotFoundException{
        lesson[] lesson = new lesson[50];

        for (int i=0;i<lesson.length;i++){
            lesson[i] = new lesson();
        }

        File lessons = new File("lessons.txt");
        Scanner sc = new Scanner(lessons);
        sc.useDelimiter("/");
        int lnum;
        for (lnum=0;sc.hasNext();lnum++){
            lesson[lnum].setName(sc.next());
            File lesson_data = new File("lessons\\lesson_"+lesson[lnum].getName()+".txt");
            Scanner sc2 = new Scanner(lesson_data);
            sc2.useDelimiter("/");

            lesson[lnum].setId(sc2.next());
            lesson[lnum].setTeacher(sc2.next());
            lesson[lnum].setStudent_num(sc2.nextInt());

            for(int i=0;sc2.hasNext();i++){
                lesson[lnum].students.add(i, new student(sc2.next(),sc2.next(),sc2.next()));
            }
        }
        for (int i=0;i<lnum;i++){
            lessonList.add(lesson[i]);
        }
        }

    public static void lessonsaver(){
        file_writer("lessons","",false);
        for (lesson l : lessonList){
            file_creator("lessons\\lesson_"+l.getName());
            file_writer("lessons\\lesson_"+l.getName(),l.getId()+"/"+l.getTeacher()+"/"+l.getStudent_num()+"/",false);
            for (student s : l.students){
                file_writer("lessons\\lesson_"+l.getName(),s.getFullname()+"/"+s.getId()+"/"+s.getNomre()+"/",true);
            }
            file_writer("lessons",l.getName()+"/",true);
            file_writer("teachers\\teacher_"+l.getTeacher(),l.getName()+"/"+l.getId()+"/",true);
        }
    }

    public static void teachersaver(){
        file_writer("teachers","",false);
        for (teacher t : teacherList){
            file_creator("teachers\\teacher_"+t.getFullname());
            file_writer("teachers\\teacher_"+t.getFullname(),t.getFullname()+"/"+t.getId()+"/"+t.getLesson_num()+"/",false);
            for(lesson l : t.getLessons()){
                file_writer("teachers\\teacher_"+t.getFullname(),l.getName()+"/"+l.getId()+"/",true);
            }
            file_writer("teachers",t.getFullname()+"/",true);
        }
    }

    public static void studentsaver(){
        file_writer("students","",false);
        for (student s : studentList){
            file_creator("students\\student_"+s.getFullname());
            file_writer("students\\student_"+s.getFullname(),s.getFullname()+"/"+s.getId()+"/"+s.getReshte()+"/",false);
            for (lesson l : s.getLessons()){
                file_writer("students\\student_"+s.getFullname(),l.getName()+"/"+l.getNomre()+"/",true);
            }
            file_writer("students",s.getFullname()+"/",true);
        }
    }

}
