CREATE SCHEMA IF NOT EXISTS `show` CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE `show`;

CREATE TABLE IF NOT EXISTS `show`
(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `version` BIGINT NOT NULL,
    `code` BINARY(16) NOT NULL,
    `name` VARCHAR(128) NOT NULL,
    `enabled` bit(1) NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`),
    UNIQUE KEY UK_show_code (code)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `auditorium_function_layout`
(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `version` BIGINT NOT NULL,
    `code` BINARY(16) NOT NULL,
    `name` VARCHAR(128) NOT NULL,
    `auditorium_code` BINARY(16) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY UK_auditorium_function_layout_code (code)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `function`
(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `version` BIGINT NOT NULL,
    `code` BINARY(16) NOT NULL,
    `date` DATETIME(6) NOT NULL,
    `enabled` BIT(1) NOT NULL DEFAULT 0,
    `show_id` BIGINT NOT NULL,
    `auditorium_function_layout_id` BIGINT NOT NULL,
    CONSTRAINT `FK_function_show` FOREIGN KEY (`show_id`) REFERENCES `show` (`id`),
    CONSTRAINT `FK_function_auditorium_function_layout` FOREIGN KEY (`auditorium_function_layout_id`) REFERENCES `auditorium_function_layout` (`id`),
    PRIMARY KEY (`id`),
    UNIQUE KEY UK_function_code (code)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `section`
(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `version` BIGINT NOT NULL,
    `code` BINARY(16) NOT NULL,
    `name` VARCHAR(128) NOT NULL,
    `seat_price` DECIMAL(19,4) NOT NULL,
    `auditorium_function_layout_id` BIGINT NOT NULL,
    CONSTRAINT `FK_section_auditorium_function_layout` FOREIGN KEY (`auditorium_function_layout_id`) REFERENCES `auditorium_function_layout` (`id`),
    PRIMARY KEY (`id`),
    UNIQUE KEY UK_section_code (code)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE IF NOT EXISTS `section_seat`
(
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `version` BIGINT NOT NULL,
    `code` BINARY(16) NOT NULL,
    `available` BIT(1) NOT NULL DEFAULT 0,
    `section_id` BIGINT NOT NULL,
    `seat_code` BINARY(16) NOT NULL,
    CONSTRAINT `FK_section_seat_section` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`),
    PRIMARY KEY (`id`),
    UNIQUE KEY UK_section_seat_code (code)
) DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;