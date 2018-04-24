package com.alvaroquintana.daggermvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Alvaro Quintana on 24-Apr-18.
 */
public class FCI implements Parcelable {
    String grupo;
    String seccion;
    String tipo;

    public FCI(){

    }

    public FCI(String grupo, String seccion, String tipo) {
        this.tipo = tipo;
        this.seccion = seccion;
        this.grupo = grupo;
    }

    public String getSeccion() {
        return seccion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getGrupo() {

        return grupo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    ///// PARCELABLE PART /////
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.grupo);
        dest.writeString(this.seccion);
        dest.writeString(this.tipo);

    }

    public FCI(Parcel in) {
        this.grupo = in.readString();
        this.seccion = in.readString();
        this.tipo = in.readString();
    }

    public static final Creator<FCI> CREATOR = new Creator<FCI>() {
        public FCI createFromParcel(Parcel source) {
            return new FCI(source);
        }

        public FCI[] newArray(int size) {
            return new FCI[size];
        }
    };
}
