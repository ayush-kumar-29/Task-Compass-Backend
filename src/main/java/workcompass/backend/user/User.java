package workcompass.backend.user;

public class User {
    private Integer userId;
    private String userName;
    private String emailId;
    private String passwordSalt;
    private String hashedPassword;

    public User(Integer userId, String userName, String emailId, String passwordSalt, String hashedPassword) {
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;
        this.passwordSalt = passwordSalt;
        this.hashedPassword = hashedPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", passwordSalt='" + passwordSalt + '\'' +
                ", hashedPassword='" + hashedPassword + '\'' +
                '}';
    }
}
