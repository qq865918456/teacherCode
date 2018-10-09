package com.qf.oa.entity;

import java.io.Serializable;

public class Resc implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resc.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resc.pid
     *
     * @mbggenerated
     */
    private Integer pid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resc.rname
     *
     * @mbggenerated
     */
    private String rname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resc.rpath
     *
     * @mbggenerated
     */
    private String rpath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resc.rdesc
     *
     * @mbggenerated
     */
    private String rdesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resc.rstate
     *
     * @mbggenerated
     */
    private Integer rstate;

    private boolean checked;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table resc
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resc.id
     *
     * @return the value of resc.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resc.id
     *
     * @param id the value for resc.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resc.pid
     *
     * @return the value of resc.pid
     *
     * @mbggenerated
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resc.pid
     *
     * @param pid the value for resc.pid
     *
     * @mbggenerated
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resc.rname
     *
     * @return the value of resc.rname
     *
     * @mbggenerated
     */
    public String getRname() {
        return rname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resc.rname
     *
     * @param rname the value for resc.rname
     *
     * @mbggenerated
     */
    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resc.rpath
     *
     * @return the value of resc.rpath
     *
     * @mbggenerated
     */
    public String getRpath() {
        return rpath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resc.rpath
     *
     * @param rpath the value for resc.rpath
     *
     * @mbggenerated
     */
    public void setRpath(String rpath) {
        this.rpath = rpath == null ? null : rpath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resc.rdesc
     *
     * @return the value of resc.rdesc
     *
     * @mbggenerated
     */
    public String getRdesc() {
        return rdesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resc.rdesc
     *
     * @param rdesc the value for resc.rdesc
     *
     * @mbggenerated
     */
    public void setRdesc(String rdesc) {
        this.rdesc = rdesc == null ? null : rdesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resc.rstate
     *
     * @return the value of resc.rstate
     *
     * @mbggenerated
     */
    public Integer getRstate() {
        return rstate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resc.rstate
     *
     * @param rstate the value for resc.rstate
     *
     * @mbggenerated
     */
    public void setRstate(Integer rstate) {
        this.rstate = rstate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resc
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Resc other = (Resc) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getRname() == null ? other.getRname() == null : this.getRname().equals(other.getRname()))
            && (this.getRpath() == null ? other.getRpath() == null : this.getRpath().equals(other.getRpath()))
            && (this.getRdesc() == null ? other.getRdesc() == null : this.getRdesc().equals(other.getRdesc()))
            && (this.getRstate() == null ? other.getRstate() == null : this.getRstate().equals(other.getRstate()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resc
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getRname() == null) ? 0 : getRname().hashCode());
        result = prime * result + ((getRpath() == null) ? 0 : getRpath().hashCode());
        result = prime * result + ((getRdesc() == null) ? 0 : getRdesc().hashCode());
        result = prime * result + ((getRstate() == null) ? 0 : getRstate().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resc
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", rname=").append(rname);
        sb.append(", rpath=").append(rpath);
        sb.append(", rdesc=").append(rdesc);
        sb.append(", rstate=").append(rstate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}