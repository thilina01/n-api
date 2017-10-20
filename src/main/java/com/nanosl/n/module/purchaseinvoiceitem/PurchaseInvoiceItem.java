package com.nanosl.n.module.purchaseinvoiceitem;

import com.fasterxml.jackson.annotation.JsonView;
import com.nanosl.n.module.item.Item;
import com.nanosl.n.module.purchaseinvoice.PurchaseInvoice;
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
@Table(name = "purchase_invoice_item")
@NamedQueries({
    @NamedQuery(name = "PurchaseInvoiceItem.findAll", query = "SELECT s FROM PurchaseInvoiceItem s")})
public class PurchaseInvoiceItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(PurchaseInvoiceItemView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(PurchaseInvoiceItemView.Quantity.class)
    @Column(name = "quantity")
    private Double quantity;
    @JsonView(PurchaseInvoiceItemView.Price.class)
    @Column(name = "price")
    private Double price;
    @JsonView(PurchaseInvoiceItemView.Item.class)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Item item;
    @JsonView(PurchaseInvoiceItemView.PurchaseInvoice.class)
    @JoinColumn(name = "purchase_invoice_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PurchaseInvoice purchaseInvoice;

}
