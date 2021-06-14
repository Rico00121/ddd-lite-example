CREATE TABLE `group_member`
(
    `id`         VARCHAR(36)  NOT NULL PRIMARY KEY,
    `group_id`   VARCHAR(36)  NOT NULL,
    `user_id`   VARCHAR(36)  NOT NULL,
    `role`       VARCHAR(10)  NOT NULL,
    `created_by` VARCHAR(36)  NOT NULL,
    `created_at` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
    `updated_at` TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3)
);
