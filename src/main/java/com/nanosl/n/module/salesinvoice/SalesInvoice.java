package com.nanosl.n.module.salesinvoice;

import com.fasterxml.jackson.annotation.JsonView;
import com.nanosl.n.module.salesinvoiceitem.SalesInvoiceItem;
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
@Table(name = "sales_invoice")
@NamedQueries({
    @NamedQuery(name = "SalesInvoice.findAll", query = "SELECT i FROM SalesInvoice   i")})
public class SalesInvoice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @JsonView(SalesInvoiceView.Id.class)
    @Column(name = "id")
    private Integer id;
    @JsonView(SalesInvoiceView.Code.class)
    @Column(name = "code")
    private Integer code;
    @JsonView(SalesInvoiceView.Amount.class)
    @Column(name = "amount", unique = true)
    private double amount;
    @JsonView(SalesInvoiceView.InvoiceDate.class)
    @Column(name = "invoice_date")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @JsonView(SalesInvoiceView.SalesInvoiceItem.class)
    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, mappedBy = "salesInvoice")
    private List<SalesInvoiceItem> salesInvoiceItemList;

}
