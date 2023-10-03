package com.example.deliveryexpress.model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "shipments")
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String trackingNumber;

    @Column(nullable = false)
    private String senderAddress;

    @Column(nullable = false)
    private String destinationAddress;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ShipmentStatus status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_received", nullable = false)
    private Date dateReceived;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_status_date", nullable = false)
    private Date lastStatusDate;

    // Геттеры и сеттеры для всех полей

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public ShipmentStatus getStatus() {
        return ShipmentStatus.valueOf(String.valueOf(status));
    }

    public void setStatus(ShipmentStatus status) {
        this.status = ShipmentStatus.valueOf(status.name());
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Date getLastStatusDate() {
        return lastStatusDate;
    }

    public void setLastStatusDate(Date lastStatusDate) {
        this.lastStatusDate = lastStatusDate;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id=" + id +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                ", status='" + status + '\'' +
                ", dateReceived=" + dateReceived +
                ", lastStatusDate=" + lastStatusDate +
                '}';
    }
}