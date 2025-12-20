namespace BrasilBurgerClient.Models
{
    using System.ComponentModel.DataAnnotations.Schema;
    [Table("complement")]
    public class Complement
    {
        public int Id { get; set; }
        public string Nom { get; set; }
        public double Prix { get; set; }
        public string ImageUrl { get; set; }
        public bool Archived { get; set; }
    }
}
