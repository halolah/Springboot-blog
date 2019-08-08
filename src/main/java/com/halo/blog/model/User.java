package com.halo.blog.model;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MYH2.ID
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MYH2.ACCOUNT_ID
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    private String accountId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MYH2.NAME
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MYH2.TOKEN
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    private String token;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MYH2.GMT_CREATE
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MYH2.GMT_MODIFIED
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    private Long gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MYH2.BIO
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    private String bio;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column MYH2.AVATAR_URL
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    private String avatarUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MYH2.ID
     *
     * @return the value of MYH2.ID
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MYH2.ID
     *
     * @param id the value for MYH2.ID
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MYH2.ACCOUNT_ID
     *
     * @return the value of MYH2.ACCOUNT_ID
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MYH2.ACCOUNT_ID
     *
     * @param accountId the value for MYH2.ACCOUNT_ID
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MYH2.NAME
     *
     * @return the value of MYH2.NAME
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MYH2.NAME
     *
     * @param name the value for MYH2.NAME
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MYH2.TOKEN
     *
     * @return the value of MYH2.TOKEN
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public String getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MYH2.TOKEN
     *
     * @param token the value for MYH2.TOKEN
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MYH2.GMT_CREATE
     *
     * @return the value of MYH2.GMT_CREATE
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MYH2.GMT_CREATE
     *
     * @param gmtCreate the value for MYH2.GMT_CREATE
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MYH2.GMT_MODIFIED
     *
     * @return the value of MYH2.GMT_MODIFIED
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public Long getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MYH2.GMT_MODIFIED
     *
     * @param gmtModified the value for MYH2.GMT_MODIFIED
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MYH2.BIO
     *
     * @return the value of MYH2.BIO
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public String getBio() {
        return bio;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MYH2.BIO
     *
     * @param bio the value for MYH2.BIO
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public void setBio(String bio) {
        this.bio = bio == null ? null : bio.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column MYH2.AVATAR_URL
     *
     * @return the value of MYH2.AVATAR_URL
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column MYH2.AVATAR_URL
     *
     * @param avatarUrl the value for MYH2.AVATAR_URL
     *
     * @mbg.generated Thu Aug 08 15:13:50 CST 2019
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }
}