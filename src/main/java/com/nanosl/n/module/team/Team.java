/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.n.module.team;

import com.fasterxml.jackson.annotation.JsonView;
import com.nanosl.n.module.teammenu.TeamMenu;
import com.nanosl.n.module.user.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(name = "team")
@NamedQueries({
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(TeamView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(TeamView.Name.class)
    @Column(name = "name")
    private String name;
    @JsonView(TeamView.Code.class)
    @Column(name = "code",unique=true)
    private String code;
    @JsonView(TeamView.TeamMenuList.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "team")
    private List<TeamMenu> teamMenuList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "team")
    private List<User> userList;

}
