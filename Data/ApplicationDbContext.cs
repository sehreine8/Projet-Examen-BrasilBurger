using Microsoft.EntityFrameworkCore;
using BrasilBurgerClient.Models;

namespace BrasilBurgerClient.Data
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
            : base(options)
        {
        }

        public DbSet<Burger> Burgers { get; set; }
        public DbSet<Menu> Menus { get; set; }
        public DbSet<Complement> Complements { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Burger>(entity =>
            {
                entity.ToTable("burger");
                entity.Property(e => e.Id).HasColumnName("id");
                entity.Property(e => e.Nom).HasColumnName("nom");
                entity.Property(e => e.Prix).HasColumnName("prix");
                entity.Property(e => e.ImageUrl).HasColumnName("image_url");
                entity.Property(e => e.Description).HasColumnName("description");
                entity.Property(e => e.Archived).HasColumnName("archived");
            });

            modelBuilder.Entity<Menu>(entity =>
            {
                entity.ToTable("menu");
                entity.Property(e => e.Id).HasColumnName("id");
                entity.Property(e => e.Nom).HasColumnName("nom");
                entity.Property(e => e.BurgerId).HasColumnName("burger_id");
                entity.Property(e => e.BoissonId).HasColumnName("boisson_id");
                entity.Property(e => e.FritesId).HasColumnName("frites_id");
                entity.Property(e => e.PrixTotal).HasColumnName("prix_total");
                entity.Property(e => e.ImageUrl).HasColumnName("image_url");
                entity.Property(e => e.Description).HasColumnName("description");
                entity.Property(e => e.Archived).HasColumnName("archived");
            });

            modelBuilder.Entity<Complement>(entity =>
            {
                entity.ToTable("complement");
                entity.Property(e => e.Id).HasColumnName("id");
                entity.Property(e => e.Nom).HasColumnName("nom");
                entity.Property(e => e.Prix).HasColumnName("prix");
                entity.Property(e => e.ImageUrl).HasColumnName("image_url");
                entity.Property(e => e.Archived).HasColumnName("archived");
            });
        }

    }
}
