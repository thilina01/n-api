package com.nanosl.n.module.salesinvoiceitem;

import com.fasterxml.jackson.annotation.JsonView;
import com.nanosl.n.module.item.Item;
import com.nanosl.n.module.salesinvoice.SalesInvoice;
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
@Table(name = "sales_invoice_item")
@NamedQueries({
    @NamedQuery(name = "SalesInvoiceItem.findAll", query = "SELECT s FROM SalesInvoiceItem s")})
public class SalesInvoiceItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SalesInvoiceItemView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SalesInvoiceItemView.Quantity.class)
    @Column(name = "quantity")
    private Double quantity;
    @JsonView(SalesInvoiceItemView.Price.class)
    @Column(name = "price")
    private Double price;
    @JsonView(SalesInvoiceItemView.Item.class)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Item item;
    @JsonView(SalesInvoiceItemView.SalesInvoice.class)
    @JoinColumn(name = "sales_invoice_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private SalesInvoice salesInvoice;

}
