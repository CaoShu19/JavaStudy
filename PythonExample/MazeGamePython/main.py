import pygame
import player
import config

pygame.init()
screen = pygame.display.set_mode((config.SCREEN_WIDTH,config.SCREEN_HEIGHT))
clock = pygame.time.Clock()

player = player.Player()

running = True
while running:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            running = False
    screen.fill("black")
    player.update()

    screen.blit(player.image, player.rect)
    pygame.display.flip()
    clock.tick(config.FRAME_PER_SECOND)

pygame.quit()