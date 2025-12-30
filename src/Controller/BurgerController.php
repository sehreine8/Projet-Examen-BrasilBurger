<?php

namespace App\Controller;
use App\Repository\BurgerRepository;


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
    public function list(
        BurgerRepository $burgerRepository,
        Request $request
    ): Response {
        $page = max(1, (int) $request->query->get('page', 1));
        $limit = 6;
        $offset = ($page - 1) * $limit;

        $burgers = $burgerRepository->findActive($limit, $offset);
        $total = $burgerRepository->countActive();
        $totalPages = (int) ceil($total / $limit);

        // AJOUT
        $burger = new Burger();
        $burger->setArchived(false);

        $form = $this->createForm(BurgerType::class, $burger);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            $burgerRepository->create($burger);
            return $this->redirectToRoute('burger_list');
        }

        return $this->render('burger/index.html.twig', [
            'burgers' => $burgers,
            'currentPage' => $page,
            'totalPages' => $totalPages,
            'form' => $form->createView()
        ]);
    }


    
    #[Route('/burgers/{id}/archive', name: 'burger_archive')]
    public function archive(Burger $burger, EntityManagerInterface $em): Response
    {
        $burger->setArchived(true);
        $em->flush();

        return $this->redirectToRoute('burger_list');
    }

    #[Route('/burgers/{id}/edit', name: 'burger_edit', methods: ['GET', 'POST'])]
    public function edit(
        Burger $burger,
        Request $request,
        BurgerRepository $burgerRepository
    ): Response {
        $form = $this->createForm(BurgerType::class, $burger);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            // ❌ pas de persist
            $burgerRepository->update(); // flush()
            return $this->redirectToRoute('burger_list');

        }

        return $this->render('burger/_form.html.twig', [
            'form' => $form->createView(),
            'burger' => $burger,
        ]);
    }

}
