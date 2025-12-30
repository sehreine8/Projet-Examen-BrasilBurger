<?php
namespace App\Form;

use App\Entity\Burger;
use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\Extension\Core\Type\CheckboxType;
use Symfony\Component\Form\Extension\Core\Type\MoneyType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolver;

class BurgerType extends AbstractType
{
    public function buildForm(FormBuilderInterface $builder, array $options): void
    {
        $builder
            ->add('nom', TextType::class, [
                'label' => 'Nom du burger'
            ])
            ->add('prix', MoneyType::class, [
                'label' => 'Prix (€)',
                'currency' => false
            ])
            ->add('description', TextareaType::class, [
                'required' => false
            ])
            ->add('imageUrl', TextType::class, [
                'label' => 'Image du burger',
                'help' => 'Collez l’URL de l’image'
            ]);
    }
}
