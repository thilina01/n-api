/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.n.module.usermenu;

import com.nanosl.n.module.user.User;
import com.nanosl.n.module.menu.Menu;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(name = "user_menu", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_id", "menu_id"})})
@NamedQueries({
    @NamedQuery(name = "UserMenu.findAll", query = "SELECT t FROM UserMenu t")})
public class UserMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(UserMenuView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(UserMenuView.Menu.class)
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Menu menu;
    @JsonView(UserMenuView.User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private User user;

}
