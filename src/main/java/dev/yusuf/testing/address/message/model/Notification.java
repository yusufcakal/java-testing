package dev.yusuf.testing.address.message.model;

public class Notification {

    private final Long memberId;
    private final String message;

    private Notification(Long memberId, String message) {
        this.memberId = memberId;
        this.message = message;
    }

    public static Notification addressUpdateSuccessNotification(Long memberId) {
        return new Notification(memberId, "Your address has been updated");
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getMessage() {
        return message;
    }
}
