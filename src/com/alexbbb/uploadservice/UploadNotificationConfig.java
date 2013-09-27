package com.alexbbb.uploadservice;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Contains the configuration of the upload notification.
 *
 * @author alexbbb (Alex Gotev)
 *
 */
public class UploadNotificationConfig implements Parcelable {

    private final int iconResourceID;
    private final String title;
    private final String message;
    private final String completed;
    private final String error;

    public UploadNotificationConfig(final int iconResourceID,
                                    final String title,
                                    final String message,
                                    final String completed,
                                    final String error)
                                    throws IllegalArgumentException{

        if (title == null || message == null || completed == null || error == null) {
            throw new IllegalArgumentException("You can't provide null parameters");
        }

        this.iconResourceID = iconResourceID;
        this.title = title;
        this.message = message;
        this.completed = completed;
        this.error = error;
    }

    public final int getIconResourceID() {
        return iconResourceID;
    }

    public final String getTitle() {
        return title;
    }

    public final String getMessage() {
        return message;
    }

    public final String getCompleted() {
        return completed;
    }

    public final String getError() {
        return error;
    }

    // This is used to regenerate the object.
    // All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<UploadNotificationConfig> CREATOR =
            new Parcelable.Creator<UploadNotificationConfig>() {
        @Override
        public UploadNotificationConfig createFromParcel(final Parcel in) {
            return new UploadNotificationConfig(in);
        }

        @Override
        public UploadNotificationConfig[] newArray(final int size) {
            return new UploadNotificationConfig[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int arg1) {
        parcel.writeInt(iconResourceID);
        parcel.writeString(title);
        parcel.writeString(message);
        parcel.writeString(completed);
        parcel.writeString(error);
    }

    private UploadNotificationConfig(Parcel in) {
        iconResourceID = in.readInt();
        title = in.readString();
        message = in.readString();
        completed = in.readString();
        error = in.readString();
    }
}
