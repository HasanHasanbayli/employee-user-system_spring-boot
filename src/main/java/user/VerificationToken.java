package user;

import java.util.Calendar;
import java.util.Date;

public class VerificationToken {
    private final int EXPIRY_DATE = 60 * 24;

    private Long id;

    private User user;

    private String token;

    private Date expiryDate;

    public VerificationToken() {
        this.expiryDate = calculateExpiryDate(EXPIRY_DATE);
    }

    public Date calculateExpiryDate(int EXPIRY_DATE) {
        //TODO Auto-generated method stub
        Calendar calendar = Calendar.getInstance();

        calendar.setTimeInMillis(new Date().getTime());

        calendar.add(Calendar.MINUTE, EXPIRY_DATE);

        return new Date(calendar.getTime().getTime());
    }


}
