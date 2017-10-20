/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nanosl.n.module.item;

import com.fasterxml.jackson.annotation.JsonView;
import com.nanosl.n.module.itemtype.ItemType;
import com.nanosl.n.module.purchaseinvoiceitem.PurchaseInvoiceItem;
import com.nanosl.n.module.salesinvoiceitem.SalesInvoiceItem;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Thilina
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "item")
@NamedQueries({
    @NamedQuery(name = "Item.findAll", query = "SELECT i FROM Item i")})
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(ItemView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(ItemView.Code.class)
    @Column(name = "code", unique = true)
    private String code;
    @JsonView(ItemView.Name.class)
    @Column(name = "name", unique = true)
    private String name;
    @JsonView(ItemView.ItemType.class)
    @JoinColumn(name = "item_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ItemType itemType;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "item")
    private List<SalesInvoiceItem> SalesInvoiceItemList;
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "item")
    private List<PurchaseInvoiceItem> PurchaseInvoiceItemList;

    public Item(int anId) {
        this.id = anId;
    }

}
