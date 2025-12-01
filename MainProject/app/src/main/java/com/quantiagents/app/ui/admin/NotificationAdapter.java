package com.quantiagents.app.ui.admin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.quantiagents.app.R;
import com.quantiagents.app.models.Notification;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    private final List<Notification> notificationList;

    public NotificationAdapter(List<Notification> notificationList) {
        this.notificationList = notificationList;
    }

    @NonNull @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification_admin, parent, false);
        return new NotificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        holder.bind(notificationList.get(position));
    }

    @Override
    public int getItemCount() { return notificationList.size(); }

    static class NotificationViewHolder extends RecyclerView.ViewHolder {
        final TextView timestampTextView;
        final TextView senderReceiverTextView;
        final TextView messageTextView;

        NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            timestampTextView = itemView.findViewById(R.id.text_view_notification_timestamp);
            senderReceiverTextView = itemView.findViewById(R.id.text_view_notification_sender_receiver);
            messageTextView = itemView.findViewById(R.id.text_view_notification_message);
        }

        void bind(final Notification notification) {
            // Format timestamp
            if (notification.getTimestamp() != null) {
                java.text.DateFormat format = java.text.DateFormat.getDateTimeInstance(
                    java.text.DateFormat.MEDIUM, java.text.DateFormat.SHORT);
                timestampTextView.setText(format.format(notification.getTimestamp()));
            } else {
                timestampTextView.setText("N/A");
            }

            // Format sender -> receiver (both are int primitives, can't be null)
            String sender = String.valueOf(notification.getSenderId());
            String receiver = String.valueOf(notification.getRecipientId());
            senderReceiverTextView.setText(sender + " → " + receiver);

            // Format message
            String type = notification.getType() != null ? notification.getType().toString() : "UNKNOWN";
            String status = notification.getStatus() != null ? notification.getStatus() : "";
            String details = notification.getDetails() != null ? notification.getDetails() : "";
            messageTextView.setText(type + ": " + status + " - " + details);
        }
    }
}