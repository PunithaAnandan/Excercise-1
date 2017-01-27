package edu.matc.entity;

// TODO Add instance variable for the date of birth
// TODO Add a calculation for the user's age. Age should not be stored, it should be calculated


import java.util.Date;

/**
 * A class to represent a user.
 *
 * @author pwaite
 */
public class User {
    private String firstName;
    private String lastName;
    private String userid;
    private String dateOfBirth;


    /**
     * Instantiates a new User.
     *
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userid    the userid
     */
    public User(String firstName, String lastName, String userid, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userid = userid;
        this.dateOfBirth = dateOfBirth;
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets userid.
     *
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * Sets userid.
     *
     * @param userid the userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * Gets dateOfBirth
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets dateOfBirth
     *
     * @param dateOfBirth the dateOfBirth
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    /**
     * This is the code for the method toString()
     */
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userid='" + userid + '\'' +
                ", dateOfBirth='" + userid + '\'' +
                '}';
    }

    /**
     * This is the code for the method getAge()
     * @return result
     */

    public int getAge() {
        int year=Integer.parseInt(this.getDateOfBirth().substring(0,4));
        int month=Integer.parseInt(this.getDateOfBirth().substring(5,7));
        int day=Integer.parseInt(this.getDateOfBirth().substring(8,10));
        Date now = new Date();
            int nowMonth = now.getMonth()+1;
            int nowYear = now.getYear()+1900;
            int result = nowYear - year;

            if (month > nowMonth) {
                result--;
            }
            else if (month == nowMonth) {
                int nowDay = now.getDate();

                if (day > nowDay) {
                    result--;
                }
            }
            return result;
    }


    /*public int calculateAge() {

        LocalDate now = LocalDate.now();
        long age = ChronoUnit.YEARS.between(dateOfBirth, now);
        return (int)age;
    }*/
}