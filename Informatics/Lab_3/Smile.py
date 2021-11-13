import pygame as pg

width, height = 900, 250
FPS = 30

pg.init()
size = width, height
pg.display.set_caption("Smile")
screen = pg.display.set_mode(size)
screen.fill((0, 0, 0))
clock = pg.time.Clock()
font = pg.font.Font(None, 250)
smile = font.render("SEMEN", True, (255, 255, 255))

run = True
while run:
    for event in pg.event.get():
        if event.type == pg.QUIT:
            run = False
    screen.blit(smile, (30, 30))
    clock.tick(FPS)
    pg.display.flip()
pg.quit()
