package com.nanosl.n.module.purchaseinvoice;

import com.fasterxml.jackson.annotation.JsonView;
import com.nanosl.n.module.purchaseinvoiceitem.PurchaseInvoiceItem;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "Purchase_invoice")
@NamedQueries({
    @NamedQuery(name = "PurchaseInvoice.findAll", query = "SELECT i FROM PurchaseInvoice   i")})
public class PurchaseInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(PurchaseInvoiceView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(PurchaseInvoiceView.Amount.class)
    @Column(name = "amount", unique = true)
    private double amount;
    @JsonView(PurchaseInvoiceView.PaidAmount.class)
    @Column(name = "paid_amount ", unique = true)
    private double paidAmount;
    @JsonView(PurchaseInvoiceView.Discount.class)
    @Column(name = "discount", unique = true)
    private double discount;
    @JsonView(PurchaseInvoiceView.InvoiceDate.class)
    @Column(name = "invoice_date")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @JsonView(PurchaseInvoiceView.PurchaseInvoiceItem.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "purchaseInvoice")
    private List<PurchaseInvoiceItem> purchaseInvoiceItemList;

}
