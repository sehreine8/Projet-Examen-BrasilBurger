<?php

namespace App\Controller;

use App\Entity\Burger;
use App\Form\BurgerType;
use Doctrine\ORM\EntityManagerInterface;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Component\Routing\Annotation\Route;

class BurgerController extends AbstractController
{
    #[Route('/burgers', name: 'burger_list')]
    #[Route('/burgers', name: 'burger_list')]
    #[Route('/burgers', name: 'burger_list')]
    public function list(EntityManagerInterface $em, Request $request): Response
    {
        // Pagination
        $page = max(1, (int) $request->query->get('page', 1));
        $limit = 6;
        $offset = ($page - 1) * $limit;

        $total = $em->getRepository(Burger::class)
            ->count(['archived' => false]);

        $burgers = $em->getRepository(Burger::class)
            ->findBy(
                ['archived' => false],
                ['id' => 'DESC'],
                $limit,
                $offset
            );

        $totalPages = (int) ceil($total / $limit);

        // === FORMULAIRE AJOUT ===
        $burger = new Burger();
        $burger->setArchived(false);

        $form = $this->createForm(BurgerType::class, $burger);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $em->persist($burger);
            $em->flush();

            return $this->redirectToRoute('burger_list');
        }

        return $this->render('burger/index.html.twig', [
            'burgers' => $burgers,
            'currentPage' => $page,
            'totalPages' => $totalPages,
            'form' => $form->createView(), // 👈 IMPORTANT
        ]);
    }



    
    #[Route('/burgers/{id}/archive', name: 'burger_archive')]
    public function archive(Burger $burger, EntityManagerInterface $em): Response
    {
        $burger->setArchived(true);
        $em->flush();

        return $this->redirectToRoute('burger_list');
    }
}
