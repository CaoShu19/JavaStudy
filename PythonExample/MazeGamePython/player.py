import pygame
import config
import math

class Player(pygame.sprite.Sprite) :
    def __init__(self):
        super().__init__()
        self.width = config.PLAYER_WIDTH
        self.height = config.PLAYER_HEIGHT
        self.forward_angle = config.PLAYER_FORWARD_ANGLE # 游戏坐标中,顺时针转动角度

        self.image_source = pygame.image.load("static/image/car.png").convert()
        self.image = pygame.transform.scale(self.image_source, (self.width,self.height))
        self.image = pygame.transform.rotate(self.image, self.forward_angle)
        self.rect = self.image.get_rect()
        self.rect.center = (config.SCREEN_WIDTH/2, config.SCREEN_HEIGHT/2)
        self.last_time = pygame.time.get_ticks()
        self.delta_time = 0

        self.move_velocity_limit = config.PLAYER_MOVE_VELOCITY_LIMIT
        self.move_velocity = config.PLAYER_MOVE_VELOCITY
        self.move_acc = config.PLAYER_MOVE_ACC
        self.friction = config.PLAYER_FRICTION

        self.rotate_velocity_limit = config.PLAYER_ROTATE_VELOCITY_LIMIT
        self.rotate_velocity = config.PLAYER_ROTATE_VELOCITY


    def update_delta_time(self):
        cur_time = pygame.time.get_ticks()
        self.delta_time = (cur_time - self.last_time) / 1000
        self.last_time = cur_time

    def move(self):
        # if abs(self.move_velocity) > config.PLAYER_ROTATE_START_VELOCITY :
        self.rotate()
        vx = self.move_velocity * math.cos(math.pi * self.forward_angle / 180)
        vy = self.move_velocity * math.sin(math.pi * self.forward_angle / 180)
        self.rect.x += vx * self.delta_time
        self.rect.y += vy * self.delta_time

    def update(self):
        self.update_delta_time()
        self.input()
        self.move()

    def rotate(self):
        self.forward_angle += self.rotate_velocity * self.delta_time
        self.image = pygame.transform.scale(self.image_source, (self.width,self.height))
        self.image = pygame.transform.rotate(self.image, self.forward_angle)
        self.image.set_colorkey("black")
        center = self.rect.center #获得当前临时图片中心
        self.rect = self.image.get_rect()
        self.rect.center = center #将中心换成新图片的中心


    def input(self):
        key_pressed = pygame.key.get_pressed()
        if key_pressed[pygame.K_s]:
            self.move_velocity += self.move_acc * self.delta_time
            self.move_velocity = min(self.move_velocity, self.move_velocity_limit)
        elif key_pressed[pygame.K_w]:
            self.move_velocity -= self.move_acc * self.delta_time
            self.move_velocity = max(self.move_velocity, -self.move_velocity_limit)
        else :
            self.move_velocity = int(self.move_velocity * self.friction)

        sign = 1
        if self.move_velocity < 0:
            sign = -1

        if key_pressed[pygame.K_a]:
            self.rotate_velocity = self.rotate_velocity_limit * sign
        elif key_pressed[pygame.K_d]:
            self.rotate_velocity = -self.rotate_velocity_limit * sign
        else:
            self.rotate_velocity = 0

