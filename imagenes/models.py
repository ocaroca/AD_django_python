from django.db import models


class Imagen(models.Model):
    autor = models.CharField(max_length=50, blank=True, null=True)
    titulo = models.CharField(max_length=50)
    precio = models.DecimalField(max_digits=10, decimal_places=2)
    reservado = models.BooleanField()
    fechacreacion = models.DateTimeField(auto_now_add=True)
    fechamodificacion = models.DateTimeField(auto_now=True)


    def __str__(self):
        return self.titulo
