package com.ecart.item.entities;

import com.ecart.item.pojos.ItemAttribute;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class ItemEntity
{
    @Id
    @GeneratedValue
    @Column(name="itemId")
    private Integer itemId;

    @Column(name="item_barcode",length = 50,nullable = false)
    private String itemBarcode;

    @Column(name="pack_uom",length = 50)
    private String packUOM;

    @Column(name = "pack_quantity")
    private Integer packQuantity;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "item_attribute",referencedColumnName = "itemId")
    private ItemAttribute itemAttribute;

    public ItemEntity(Integer itemId, String itemBarcode, String packUOM, Integer packQuantity, ItemAttribute itemAttribute) {
        this.itemId = itemId;
        this.itemBarcode = itemBarcode;
        this.packUOM = packUOM;
        this.packQuantity = packQuantity;
        this.itemAttribute = itemAttribute;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemBarcode() {
        return itemBarcode;
    }

    public void setItemBarcode(String itemBarcode) {
        this.itemBarcode = itemBarcode;
    }

    public String getPackUOM() {
        return packUOM;
    }

    public void setPackUOM(String packUOM) {
        this.packUOM = packUOM;
    }

    public Integer getPackQuantity() {
        return packQuantity;
    }

    public void setPackQuantity(Integer packQuantity) {
        this.packQuantity = packQuantity;
    }

    public ItemAttribute getItemAttribute() {
        return itemAttribute;
    }

    public void setItemAttribute(ItemAttribute itemAttribute) {
        this.itemAttribute = itemAttribute;
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "itemId=" + itemId +
                ", itemBarcode='" + itemBarcode + '\'' +
                ", packUOM='" + packUOM + '\'' +
                ", packQuantity=" + packQuantity +
                ", itemAttribute=" + itemAttribute +
                '}';
    }
}
