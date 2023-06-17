package com.example.booksrating;


import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private String title;
    private String author;
    private String comment;
    private float rate;

    public Book(String title, String author,
                String comment, float rate){
        this.title = title;
        this.author = author;
        this.comment = comment;
        this.rate = rate;
    }

    //generado automáticamente al implementar Parcelable
    protected Book(Parcel in) {
        title = in.readString();
        author = in.readString();
        comment = in.readString();
        rate = in.readFloat();
    }

    //generado automáticamente al implementar Parcelable
    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    //generado automáticamente al implementar Parcelable
    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        //esto si lo tuvimos que agregar
        parcel.writeString(title);
        parcel.writeString(author);
        parcel.writeString(comment);
        parcel.writeFloat(rate);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public float getRate() {
        return rate;
    }
}
