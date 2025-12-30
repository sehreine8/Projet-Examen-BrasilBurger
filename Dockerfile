FROM php:8.3-apache

# Installer dépendances système
RUN apt-get update && apt-get install -y \
    git \
    unzip \
    libpq-dev \
    && docker-php-ext-install pdo pdo_pgsql

# Activer rewrite (obligatoire pour Symfony)
RUN a2enmod rewrite

# Installer Composer
COPY --from=composer:2 /usr/bin/composer /usr/bin/composer

# Définir le dossier de travail
WORKDIR /var/www/html

# Copier le projet
COPY . .

# Installer dépendances Symfony
RUN composer install --no-dev --optimize-autoloader --no-scripts

# Pointer Apache vers /public
RUN sed -i 's|/var/www/html|/var/www/html/public|g' \
    /etc/apache2/sites-available/000-default.conf

# Droits
RUN chown -R www-data:www-data /var/www/html

# Port exposé pour Render
EXPOSE 80
