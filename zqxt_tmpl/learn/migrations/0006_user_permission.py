# Generated by Django 2.0.1 on 2018-02-05 07:06

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('learn', '0005_list_info_img'),
    ]

    operations = [
        migrations.AddField(
            model_name='user',
            name='permission',
            field=models.BooleanField(default=True),
        ),
    ]
