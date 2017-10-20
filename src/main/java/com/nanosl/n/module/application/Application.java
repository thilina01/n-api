/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.n.module.application;

import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "application")
@NamedQueries({
    @NamedQuery(name = "Application.findAll", query = "SELECT c FROM Application c")})
public class Application implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ApplicationView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ApplicationView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(ApplicationView.Name.class)
    @Column(name = "name", unique = true)
    private String name;
    @JsonView(ApplicationView.ShortName.class)
    @Column(name = "short_name", unique = true)
    private String shortName;

}
