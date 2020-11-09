package com.example.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable{
    private String name;
    private int age;
    private Score score;

    public Student(String name, int age, Score score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }


    protected Student(Parcel in) {
        name = in.readString();
        age = in.readInt();
        score = in.readParcelable(Score.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeParcelable(score, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    static class Score implements Parcelable {
        private int math;
        private int english;
        private String grade;

        public Score(int math, int english) {
            this.math = math;
            this.english = english;
            if (math>=90&&english>=90){
                grade = "学霸";
            }else {
                grade = "学渣";
            }
        }

        protected Score(Parcel in) {
            math = in.readInt();
            english = in.readInt();
            grade = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(math);
            dest.writeInt(english);
            dest.writeString(grade);
        }

        public static final Creator<Score> CREATOR = new Creator<Score>() {
            @Override
            public Score createFromParcel(Parcel in) {
                return new Score(in);
            }

            @Override
            public Score[] newArray(int size) {
                return new Score[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }




        public int getMath() {
            return math;
        }

        public void setMath(int math) {
            this.math = math;
        }

        public int getEnglish() {
            return english;
        }

        public void setEnglish(int english) {
            this.english = english;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }
}





























