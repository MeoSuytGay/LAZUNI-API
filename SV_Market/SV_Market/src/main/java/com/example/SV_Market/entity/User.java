    package com.example.SV_Market.entity;

    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    import org.springframework.data.domain.Auditable;

    import java.util.Date;
    import java.util.UUID;

    @Entity
    @Table(name = "User")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class User    {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(name = "userid", length = 50)  // Match userId column
        private String userId;

        @Column(name = "username", length = 100, nullable = false)  // Match userName column
        private String userName;

        @Column(name = "password", length = 100, nullable = false)
        private String password;

        @Column(name = "role", length = 50)
        private String role;

        @Column(name = "phonenum", length = 15)  // Match phoneNum column
        private String phoneNum;

        @Column(name = "email", length = 100)
        private String email;

        @Column(name = "address", length = 355)  // Match address column
        private String address;

        @Column(name = "balance", columnDefinition = "DOUBLE DEFAULT 0.0")
        private Double balance;

        @Column(name = "profilepicture", length = 255)  // Match profilePicture column
        private String profilePicture;

        @Column(name = "created_at")
        @Temporal(TemporalType.DATE)
        private Date createdAt;


//        private boolean accountVerified;
//        private boolean loginDisabled;

    }
