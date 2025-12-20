namespace BrasilBurgerClient.Models

{
    using System.ComponentModel.DataAnnotations.Schema;

    [Table("burger")]
    public class Burger
    {
        public int Id { get; set; }
        public string Nom { get; set; }
        public double Prix { get; set; }
        public string ImageUrl { get; set; }
        public string? Description { get; set; }
        public bool Archived { get; set; }
    }
}
